package com.project.shopping.shopping.Controller;


import com.project.shopping.shopping.Exception.AuthenticationFailedException;
import com.project.shopping.shopping.Exception.SignUpRestrictedException;
import com.project.shopping.shopping.entity.UserAuthTokenEntity;
import com.project.shopping.shopping.entity.UserEntity;
import com.project.shopping.shopping.reponse.LoginResponse;
import com.project.shopping.shopping.reponse.UserResponse;
import com.project.shopping.shopping.request.SignupUserRequest;
import com.project.shopping.shopping.service.AuthenticationService;
import com.project.shopping.shopping.service.SignupBusinessService;
import com.project.shopping.shopping.type.RoleCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.UUID;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private SignupBusinessService signupBusinessService;

    @RequestMapping(method= RequestMethod.POST, path="/user/signup")
    public ResponseEntity<UserResponse> signup(@RequestBody SignupUserRequest signupUserRequest)throws SignUpRestrictedException
    {
        final UserEntity userEntity=new UserEntity();
        userEntity.setUuid(UUID.randomUUID().toString());
        userEntity.setFirstName(signupUserRequest.getFirstName());
        System.out.println(signupUserRequest.getFirstName());
        userEntity.setLastName(signupUserRequest.getLastName());
        userEntity.setUserName(signupUserRequest.getUserName());
        userEntity.setEmail(signupUserRequest.getEmail());
        userEntity.setPassword(signupUserRequest.getPassword());
        userEntity.setCountry(signupUserRequest.getCountry());
        userEntity.setDob(signupUserRequest.getDob());
        System.out.println(signupUserRequest.getDob());
        userEntity.setContactNumber(signupUserRequest.getContactNumber());
        userEntity.setSalt("1234abc");
        userEntity.setRole(RoleCheck.getEnum(0).toString()); //use role entity later on
        //System.out.println(userEntity);
        final UserEntity createdUserEntity=signupBusinessService.signup(userEntity);
        UserResponse userResponse=new UserResponse().id(createdUserEntity.getUuid()).status("USER SUCCESSFULLY REGISTERED");
        return new ResponseEntity<UserResponse>(userResponse, HttpStatus.CREATED);
    }

    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(method = RequestMethod.POST, path = "/user/signin")
    public ResponseEntity<LoginResponse> signin(@RequestHeader("authorization") final String authorization) throws AuthenticationFailedException {
        //Basic dXNlcm5hbWU6cGFzc3dvcmQ=
        //above is a sample encoded text where the username is "username" and password is "password" seperated by a ":"
        byte[] decode = Base64.getDecoder().decode(authorization.split("Basic ")[1]);
        String decodedText = new String(decode);
        String[] decodedArray = decodedText.split(":");

        UserAuthTokenEntity userAuthToken = authenticationService.authenticate(decodedArray[0],decodedArray[1]);
        UserEntity user = userAuthToken.getUser();

        LoginResponse authorizedUserResponse =  new LoginResponse().id(user.getUuid())
                .status("SIGNED IN SUCCESSFULLY").accessToken(userAuthToken.getAccessToken()).username(decodedArray[0]);

        return new ResponseEntity<LoginResponse>(authorizedUserResponse , HttpStatus.OK);
    }

}

package com.project.shopping.shopping.service;

import com.project.shopping.shopping.Exception.AuthorizationFailedException;
import com.project.shopping.shopping.Exception.SignUpRestrictedException;
import com.project.shopping.shopping.entity.UserAuthTokenEntity;
import com.project.shopping.shopping.entity.UserEntity;
import com.project.shopping.shopping.repository.AuthRepository;
import com.project.shopping.shopping.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserAdminBusinessService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordCryptographyProvider cryptographyProvider;

    @Transactional(propagation = Propagation.REQUIRED)
    public UserEntity signup(UserEntity userEntity)throws SignUpRestrictedException
    {

        List<UserEntity> userNameEntity = userRepository.userByUserName(userEntity.getUserName());
        List<UserEntity> emailEntity = userRepository.userByEmail(userEntity.getEmail());

        if (userNameEntity.size()!=0 && userEntity.getUserName().equals(userNameEntity.get(0).getUserName())) {
            throw new SignUpRestrictedException("SGR-001", "Try any other Username, this Username has already been taken");
        }

//         Go for user creation only if email id are unique
//        System.out.println(userEntity.getEmail());
//        System.out.println(emailEntity.get(0).getEmail());
        if (emailEntity.size()!=0 && userEntity.getEmail().equals(emailEntity.get(0).getEmail())) {
            throw new SignUpRestrictedException("SGR-002", "This user has already been registered, try with any other emailId");
        }

        String[] encryptedText = cryptographyProvider.encrypt(userEntity.getPassword());
        userEntity.setSalt(encryptedText[0]);
        userEntity.setPassword(encryptedText[1]);
//        System.out.println("chk2");
        return userRepository.save(userEntity);
    }

    @Autowired
    AuthRepository authRepository;

    public UserEntity checkUser(String accesstoken)throws AuthorizationFailedException {
        List<UserAuthTokenEntity> userAuthTokenEntity = authRepository.getUserByAuthToken(accesstoken);

        if (userAuthTokenEntity.get(0) == null) {
            throw new AuthorizationFailedException("ATHR-001", "User has not signed in");
        }

        if (userAuthTokenEntity.get(0).getLogoutAt() != null) {
            throw new AuthorizationFailedException("ATHR-002", "User is signed out");
        }
        return userAuthTokenEntity.get(0).getUser();
    }

}

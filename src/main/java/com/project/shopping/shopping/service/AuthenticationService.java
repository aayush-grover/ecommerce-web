package com.project.shopping.shopping.service;

import com.project.shopping.shopping.Exception.AuthenticationFailedException;
import com.project.shopping.shopping.entity.UserAuthTokenEntity;
import com.project.shopping.shopping.entity.UserEntity;
import com.project.shopping.shopping.repository.AuthRepository;
import com.project.shopping.shopping.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.List;

@Service
public class AuthenticationService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthRepository authRepository;


    @Autowired
    private PasswordCryptographyProvider cryptographyProvider;

    @Transactional(propagation = Propagation.REQUIRED)
    public UserAuthTokenEntity authenticate(final String username, final String password) throws AuthenticationFailedException {
        List<UserEntity> userEntity = userRepository.userByUserName(username);
//        System.out.println(userEntity.getUserName());
//        System.out.println(userEntity.getPassword());
//        System.out.println(userEntity.size());
        if(userEntity.size() == 0){
            throw new AuthenticationFailedException("ATH-001", "This username does not exist");
        }

        final String encryptedPassword = cryptographyProvider.encrypt(password, userEntity.get(0).getSalt());
        //System.out.println(encryptedPassword);
        if(encryptedPassword.equals(userEntity.get(0).getPassword())){
            JwtTokenProvider jwtTokenProvider = new JwtTokenProvider(encryptedPassword);
//            System.out.println("chk1");
            UserAuthTokenEntity userAuthToken = new UserAuthTokenEntity();
//            System.out.println("chk2");
            userAuthToken.setUser(userEntity.get(0));
            final ZonedDateTime now = ZonedDateTime.now();
            final ZonedDateTime expiresAt = now.plusHours(8);
            userAuthToken.setAccessToken(jwtTokenProvider.generateToken(userEntity.get(0).getUuid(), now, expiresAt));
//            System.out.println("chk3");
            userAuthToken.setLoginAt(now);
            userAuthToken.setExpiresAt(expiresAt);
            userAuthToken.setUuid(userEntity.get(0).getUuid());
            authRepository.save(userAuthToken);
            //userDao.updateUser(userEntity);
            userAuthToken.setLogoutAt(null);
//            System.out.println("chk4");
            return userAuthToken;
        }
        else{
            throw new AuthenticationFailedException("ATH-002", "Password failed");
        }

    }
}

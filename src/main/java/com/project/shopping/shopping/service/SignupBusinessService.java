package com.project.shopping.shopping.service;

import com.project.shopping.shopping.Exception.SignUpRestrictedException;
import com.project.shopping.shopping.entity.UserEntity;
import com.project.shopping.shopping.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SignupBusinessService {

    @Autowired
    UserAdminBusinessService userAdminBusinessService;

    @Transactional(propagation = Propagation.REQUIRED)
    public UserEntity signup(UserEntity userEntity)throws SignUpRestrictedException
    {
//        System.out.println("chk1");
        return userAdminBusinessService.signup(userEntity);
    }

}

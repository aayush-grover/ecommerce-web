package com.project.shopping.shopping.service;

import com.project.shopping.shopping.Exception.CartItemNotFoundException;
import com.project.shopping.shopping.entity.CartEntity;
import com.project.shopping.shopping.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public CartEntity addtocart(CartEntity cartEntity){
//        List<CartEntity> cartEntities = cartRepository.categoryByName(cartEntity.getUsername());

        cartRepository.save(cartEntity);
        return  cartEntity;
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public List<CartEntity> allCartItems(String username)
    {
        List<CartEntity> cartEntities = cartRepository.userByUserName(username);
//        System.out.println(cartEntities.size());
        return cartEntities;
    }
}

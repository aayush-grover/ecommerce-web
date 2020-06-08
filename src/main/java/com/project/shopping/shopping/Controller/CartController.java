package com.project.shopping.shopping.Controller;

import com.project.shopping.shopping.Exception.AuthorizationFailedException;
import com.project.shopping.shopping.Exception.CartItemNotFoundException;
import com.project.shopping.shopping.entity.CartEntity;
import com.project.shopping.shopping.entity.UserEntity;
import com.project.shopping.shopping.reponse.UserResponse;
import com.project.shopping.shopping.request.CartRequest;
import com.project.shopping.shopping.service.CartService;
import com.project.shopping.shopping.service.UserAdminBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class CartController {

    @Autowired
    UserAdminBusinessService userAdminBusinessService;

    @Autowired
    CartService cartService;

    @RequestMapping(method= RequestMethod.POST, path="/cart/add")
    public ResponseEntity<UserResponse> addToCart(@RequestBody CartRequest cartRequest, @RequestHeader("accessToken") final String accesstoken)throws AuthorizationFailedException {
        UserEntity userEntity=userAdminBusinessService.checkUser(accesstoken);

        CartEntity cartEntity=new CartEntity();

        cartEntity.setUuid(UUID.randomUUID().toString());
        cartEntity.setImage(cartRequest.getImage());
        cartEntity.setIname(cartRequest.getIname());
        cartEntity.setSpecs(cartRequest.getSpecs());
        cartEntity.setPrice(cartRequest.getPrice());
        cartEntity.setUsername(cartRequest.getUsername());

        CartEntity createdCartEntity=cartService.addtocart(cartEntity);

        UserResponse userResponse=new UserResponse().id(createdCartEntity.getUuid()).status("ADDED TO CART");
        return new ResponseEntity<UserResponse>(userResponse, HttpStatus.CREATED);
    }

    @RequestMapping(method= RequestMethod.GET, path="/{username}/cart/items")
    public List<CartEntity> allItem(@PathVariable final String username)
    {
        List<CartEntity> cartEntities=cartService.allCartItems(username);
        return cartEntities;
    }

}

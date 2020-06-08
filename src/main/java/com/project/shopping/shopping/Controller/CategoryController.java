package com.project.shopping.shopping.Controller;

import com.project.shopping.shopping.Exception.AuthorizationFailedException;
import com.project.shopping.shopping.Exception.CategoryExistException;
import com.project.shopping.shopping.Exception.CategoryNotFoundException;
import com.project.shopping.shopping.entity.CategoryEntity;
import com.project.shopping.shopping.entity.ItemEntity;
import com.project.shopping.shopping.entity.UserEntity;
import com.project.shopping.shopping.reponse.CategoryResponse;
import com.project.shopping.shopping.reponse.ItemResponse;
import com.project.shopping.shopping.request.ItemRequest;
import com.project.shopping.shopping.service.CategoryService;
import com.project.shopping.shopping.service.ItemService;
import com.project.shopping.shopping.service.UserAdminBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    UserAdminBusinessService userAdminBusinessService;

    @RequestMapping(method= RequestMethod.POST, path="/category/create/{itemType}")
    public ResponseEntity<CategoryResponse> createCategory(@PathVariable("itemType") final String itemType, @RequestHeader("accessToken") final String accesstoken)throws AuthorizationFailedException, CategoryExistException {
        UserEntity userEntity=userAdminBusinessService.checkUser(accesstoken);

        CategoryEntity categoryEntity=new CategoryEntity();

        categoryEntity.setUuid(UUID.randomUUID().toString());
        categoryEntity.setCategory(itemType);
        categoryEntity.setUser(userEntity);

        CategoryEntity createdCategory=categoryService.createCategory(categoryEntity);

        CategoryResponse categoryResponse=new CategoryResponse().id(createdCategory.getUuid()).status("CATEGORY CREATED").category(createdCategory.getUuid());
        return new ResponseEntity<CategoryResponse>(categoryResponse, HttpStatus.CREATED);
    }

    @Autowired
    ItemService itemService;

    @RequestMapping(method= RequestMethod.POST, path="/category/{categoryId}/item/add")
    public ResponseEntity<ItemResponse> addItem (@RequestBody final ItemRequest itemRequest, @PathVariable("categoryId") final String categoryId, @RequestHeader("accessToken") final String accesstoken)throws AuthorizationFailedException, CategoryNotFoundException {
        //check for user
        UserEntity userEntity=userAdminBusinessService.checkUser(accesstoken);
        //check for category
        CategoryEntity categoryEntity=categoryService.getCategoryByUuid(categoryId);

        ItemEntity itemEntity=new ItemEntity();
        itemEntity.setUuid(UUID.randomUUID().toString());
        System.out.println(itemRequest.getIname());
        itemEntity.setImage(itemRequest.getImage());
        itemEntity.setIname(itemRequest.getIname());
        itemEntity.setSpecs(itemRequest.getSpecs());
        itemEntity.setPrice(itemRequest.getPrice());
        itemEntity.setCategory(categoryEntity);
        itemEntity.setCategoryuuid(categoryEntity.getUuid());
        itemEntity.setUser(userEntity);
        System.out.println(itemEntity.getPrice());

        ItemEntity createdItemEntity=itemService.addItem(itemEntity);

        ItemResponse itemResponse=new ItemResponse().id(createdItemEntity.getUuid()).status("ITEM ADDED");
        return new ResponseEntity<ItemResponse>(itemResponse, HttpStatus.CREATED);
    }

    @RequestMapping(method= RequestMethod.GET, path="/items/all")
    public HashMap<String, List<ItemEntity>> allItem()
    {
        HashMap<String, List<ItemEntity>> h =new HashMap<String, List<ItemEntity>>();
        List<CategoryEntity> categoryEntityList=categoryService.allCategory();
        for(CategoryEntity categoryEntity : categoryEntityList)
        {
//            System.out.println(categoryEntity);
            List<ItemEntity> itemEntityList =itemService.allItemByCategory(categoryEntity.getUuid());
//            System.out.println(itemEntityList);
            h.put(categoryEntity.getCategory(),itemEntityList);
        }
        return h;
    }




}

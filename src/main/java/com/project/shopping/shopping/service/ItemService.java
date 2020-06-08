package com.project.shopping.shopping.service;


import com.project.shopping.shopping.entity.CategoryEntity;
import com.project.shopping.shopping.entity.ItemEntity;
import com.project.shopping.shopping.repository.CategoryRepository;
import com.project.shopping.shopping.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public ItemEntity addItem(ItemEntity itemEntity){
        System.out.println("chk1");
        itemRepository.save(itemEntity);
        return  itemEntity;
    }

    @Autowired
    CategoryRepository categoryRepository;

    public List<ItemEntity> allItemByCategory(String categoryUuid)
    {
        List<ItemEntity> l = itemRepository.allItemByCategory(categoryUuid);
        return l;
    }

}

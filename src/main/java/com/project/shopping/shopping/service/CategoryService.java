package com.project.shopping.shopping.service;

import com.project.shopping.shopping.Exception.CategoryExistException;
import com.project.shopping.shopping.Exception.CategoryNotFoundException;
import com.project.shopping.shopping.entity.CategoryEntity;
import com.project.shopping.shopping.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public CategoryEntity createCategory(CategoryEntity categoryEntity)throws CategoryExistException {
        List<CategoryEntity> categoryEntities = categoryRepository.categoryByName(categoryEntity.getCategory());
//        System.out.println(categoryEntities.get(0));
        if (categoryEntities.size()!=0) {
            throw new CategoryExistException(categoryEntities.get(0).getUuid(), "This Category already exists");
        }
        categoryRepository.save(categoryEntity);
        return  categoryEntity;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public CategoryEntity getCategoryByUuid(String categoryId) throws CategoryNotFoundException
    {
        List<CategoryEntity> categoryEntities=categoryRepository.CategoryByUuid(categoryId);
        if(categoryEntities.size() == 0)
        {
            throw new CategoryNotFoundException("CAT-001","The Category entered is invalid");
        }
        return categoryEntities.get(0);
    }

    public List<CategoryEntity> allCategory()
    {
        return categoryRepository.findAll();
    }
}

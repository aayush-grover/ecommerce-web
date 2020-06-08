package com.project.shopping.shopping.repository;

import com.project.shopping.shopping.entity.CategoryEntity;
import com.project.shopping.shopping.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity,Long> {
    List<ItemEntity> allItemByCategory(String categoryuuid);
}

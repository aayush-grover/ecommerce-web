package com.project.shopping.shopping.repository;

import com.project.shopping.shopping.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {
    List<CategoryEntity> categoryByName(String category);
    List<CategoryEntity> CategoryByUuid(String uuid);

}

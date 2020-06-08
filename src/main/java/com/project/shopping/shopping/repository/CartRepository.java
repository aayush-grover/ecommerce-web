package com.project.shopping.shopping.repository;

import com.project.shopping.shopping.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<CartEntity,Long> {
    List<CartEntity> userByUserName(String username);
}

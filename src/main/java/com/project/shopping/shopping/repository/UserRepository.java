package com.project.shopping.shopping.repository;

import com.project.shopping.shopping.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long>{
    List<UserEntity> userByUserName(String userName);
    List<UserEntity> userByEmail(String email);
}

package com.project.shopping.shopping.repository;

import com.project.shopping.shopping.entity.UserAuthTokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthRepository extends JpaRepository<UserAuthTokenEntity,Long> {
    List<UserAuthTokenEntity> getUserByAuthToken(String accessToken);
}

package com.example.jwt.Repository;

import com.example.jwt.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {


    Boolean existsByUsername(String username);
    UserEntity findByUsername(String username);
}

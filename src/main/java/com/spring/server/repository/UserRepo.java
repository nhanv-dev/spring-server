package com.spring.server.repository;

import com.spring.server.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User, Long> {
    @Query()
    User findOneByEmail(String email);
    
    @Query()
    Boolean existsByEmail(String email);
}
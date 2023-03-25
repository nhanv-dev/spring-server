package com.spring.server.repository;

import com.spring.server.model.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CartItemRepo extends JpaRepository<CartItem, Long> {
    @Query()
    void deleteById(Long id);
}
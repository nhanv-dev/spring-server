package com.spring.server.repository;

import com.spring.server.model.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface CartRepo extends JpaRepository<Cart, Long> {
    @Query()
    Set<Cart> findAllByUser_Id(Long userId);

    @Query()
    Cart findOneByUser_IdAndShop_Id(Long userId, Long shopId);
}
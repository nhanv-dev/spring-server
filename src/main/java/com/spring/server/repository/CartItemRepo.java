package com.spring.server.repository;

import com.spring.server.model.entity.CartItem;
import org.hibernate.annotations.SQLUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CartItemRepo extends JpaRepository<CartItem, Long> {
    @Query()
    void deleteById(Long id);

    @Query("UPDATE CartItem c SET c.quantity=:quantity WHERE c.id=:id")
    @Modifying
    void updateQuantity(Long id,Integer quantity);
}
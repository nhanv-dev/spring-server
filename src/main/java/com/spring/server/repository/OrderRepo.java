package com.spring.server.repository;

import com.spring.server.model.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface OrderRepo extends JpaRepository<Order, Long> {
    @Query()
    List<Order> findAllByUser_Id(Long userId);
}
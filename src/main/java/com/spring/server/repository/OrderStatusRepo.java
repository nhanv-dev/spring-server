package com.spring.server.repository;

import com.spring.server.model.constant.EOrderStatus;
import com.spring.server.model.entity.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderStatusRepo extends JpaRepository<OrderStatus, Long> {
    @Query()
    OrderStatus findOneByStatus(EOrderStatus status);
}
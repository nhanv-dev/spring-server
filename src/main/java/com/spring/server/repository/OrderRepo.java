package com.spring.server.repository;

import com.spring.server.model.entity.Order;
import com.spring.server.model.entity.OrderStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface OrderRepo extends JpaRepository<Order, Long> {
    @Query()
    Order findOneById(Long id);

    @Query()
    Page<Order> findAllByShop_Id(Pageable pageable, Long userId);

    @Query()
    Page<Order> findAllByUser_Id(Pageable pageable, Long userId);

    @Query()
    Page<Order> findAllByUser_IdAndOrderStatus_Id(Pageable pageable, Long userId, Long orderStatusId);
}
package com.spring.server.repository;

import com.spring.server.model.entity.CancelledOrder;
import com.spring.server.model.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CancelledOrderRepo extends JpaRepository<CancelledOrder, Long> {
    @Query()
    CancelledOrder findOneByOrder_Id(Long orderId);

}
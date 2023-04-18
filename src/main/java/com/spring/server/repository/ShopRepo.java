package com.spring.server.repository;

import com.spring.server.model.entity.Shop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ShopRepo extends JpaRepository<Shop, Long> {

    @Query()
    Shop findOneById(Long id);

    @Query()
    Shop findOneByUserId(Long id);

    @Query("SELECT s FROM Shop s WHERE " +
            "s.shopName LIKE CONCAT('%', :name, '%')")
    Shop searchShopByName(String name);
}
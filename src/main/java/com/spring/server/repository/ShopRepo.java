package com.spring.server.repository;

import com.spring.server.model.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ShopRepo extends JpaRepository<Shop, Long> {

    @Query()
    Shop findOneById(Long id);

    @Query()
    Shop findOneBySlug(String slug);

    @Query()
    Shop findOneByUserId(Long id);

    @Query("update Shop s set s.productTotal = (select count(p) from Product p where p.shop.id =:id) where s.id=:id")
    @Modifying()
    void updateProductTotalById(Long id);
}
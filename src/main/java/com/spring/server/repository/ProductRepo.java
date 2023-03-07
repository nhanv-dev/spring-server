package com.spring.server.repository;

import com.spring.server.entity.Category;
import com.spring.server.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepo extends JpaRepository<Product, Long> {

    @Query()
    Product findOneById(Long id);

    @Query()
    Page<Product> findByOrderByCreatedAt(Pageable pageable);
}
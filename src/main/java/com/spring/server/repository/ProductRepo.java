package com.spring.server.repository;

import com.spring.server.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepo extends JpaRepository<Product, Long> {

    @Query()
    Product findOneById(Long id);
    @Query()
    Product findOneBySlug(String slug);
    @Query()
    Page<Product> findByOrderByCreatedAtDesc(Pageable pageable);

    @Query()
    Page<Product> findByOrderByCreatedAtAsc(Pageable pageable);
}
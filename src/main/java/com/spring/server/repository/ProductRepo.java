package com.spring.server.repository;

import com.spring.server.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface ProductRepo extends JpaRepository<Product, Long> {

    @Query()
    Product findOneById(Long id);

    @Query()
    Product findOneBySlug(String slug);

    @Query()
    Page<Product> findAllByOrderByCreatedAtDesc(Pageable pageable);

    @Query()
    Page<Product> findAllByCategory_SlugOrSubCategory_Slug(Pageable pageable, String categorySlug, String subCategorySlug);

    @Query()
    Page<Product> findAllByShop_Id(Pageable pageable, Long shopId);

    @Query()
    Page<Product> findAllByOrderByCreatedAtAsc(Pageable pageable);

    @Query(value = "DELETE FROM Product p WHERE p.id =:id")
    void deleteById(Long id);
}
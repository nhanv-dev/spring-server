package com.spring.server.repository;

import com.spring.server.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CategoryRepo extends JpaRepository<Category, Long> {
    @Query("SELECT cate FROM Category cate")
    Page<Category> findLimit(Pageable pageable);

}
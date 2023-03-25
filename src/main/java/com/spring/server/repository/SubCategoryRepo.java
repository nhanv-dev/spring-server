package com.spring.server.repository;

import com.spring.server.model.entity.Category;
import com.spring.server.model.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubCategoryRepo extends JpaRepository<SubCategory, Long> {
    @Query()
    List<SubCategory> findByCategoryId(long categoryId);

    @Query()
    SubCategory findOneBySlug(String slug);

}
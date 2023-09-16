package com.spring.server.service;

import com.spring.server.model.dto.CategoryDto;
import com.spring.server.model.dto.SubCategoryDto;
import com.spring.server.model.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {

    CategoryDto findOneById(Long id);

    CategoryDto findOneBySlug(String slug);

    List<CategoryDto> findAll();

    List<CategoryDto> findAllWithoutSub();

    List<CategoryDto> findByCategoryId(Long id);

    Page<CategoryDto> findByPageable(Pageable pageable);

    Page<CategoryDto> findByPageableWithoutSub(Pageable pageable);

    List<SubCategoryDto> findSubCategoryByCategoryId(Long id);

    void update(CategoryDto category);

}

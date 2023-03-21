package com.spring.server.service;

import com.spring.server.model.dto.CategoryDto;
import com.spring.server.model.dto.SubCategoryDto;
import com.spring.server.model.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {

    CategoryDto findOneById(long id);

    List<CategoryDto> findAll();

    List<CategoryDto> findAllWithoutSub();

    List<CategoryDto> findByCategoryId(long id);

    Page<CategoryDto> findByPageable(Pageable pageable);

    List<SubCategoryDto> findSubCategoryByCategoryId(long id);

    void update(CategoryDto category);

}

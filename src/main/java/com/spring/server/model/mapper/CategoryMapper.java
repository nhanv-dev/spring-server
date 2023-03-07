package com.spring.server.model.mapper;

import com.spring.server.entity.Category;
import com.spring.server.entity.SubCategory;
import com.spring.server.model.dto.CategoryDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryMapper {


    public static CategoryDto toDto(Category category) {
        CategoryDto result = new CategoryDto();
        result.setId(category.getId());
        result.setTitle(category.getTitle());
        result.setSlug(category.getSlug());
        result.setIcon(category.getIcon());
        result.setSubCategories(SubCategoryMapper.toDto(category.getSubCategories()));
        return result;
    }

    public static List<CategoryDto> toDto(List<Category> categories) {
        List<CategoryDto> list = new ArrayList<>();
        for (Category category : categories) {
            list.add(CategoryMapper.toDto(category));
        }
        return list;
    }

    public static Category toEntity(CategoryDto category) {
        Category result = new Category();
        result.setId(category.getId());
        result.setTitle(category.getTitle());
        result.setSlug(category.getSlug());
        result.setIcon(category.getIcon());
        result.setSubCategories(SubCategoryMapper.toEntity(category.getSubCategories()));
        for (SubCategory subCategory:result.getSubCategories()             ) {

        }
        return result;
    }
}

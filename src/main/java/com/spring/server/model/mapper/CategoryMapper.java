package com.spring.server.model.mapper;

import com.spring.server.model.entity.Category;
import com.spring.server.model.entity.SubCategory;
import com.spring.server.model.dto.CategoryDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Component
public class CategoryMapper {
    public static CategoryDto toDto(Category category) {
        CategoryDto result = new CategoryDto();
        result.setId(category.getId());
        result.setTitle(category.getTitle());
        result.setSlug(category.getSlug());
        result.setIcon(category.getIcon());
        result.setSubCategories(SubCategoryMapper.toDtos(category.getSubCategories()));
        return result;
    }

    public static Set<CategoryDto> toDtos(Set<Category> categories) {
        Set<CategoryDto> list = new TreeSet<>();
        for (Category category : categories) {
            list.add(CategoryMapper.toDto(category));
        }
        return list;
    }

    public static List<CategoryDto> toDtos(List<Category> categories) {
        List<CategoryDto> list = new ArrayList<>();
        for (Category category : categories) {
            list.add(CategoryMapper.toDto(category));
        }
        return list;
    }

    public static CategoryDto toDtoWithoutSub(Category category) {
        CategoryDto result = new CategoryDto();
        result.setId(category.getId());
        result.setTitle(category.getTitle());
        result.setSlug(category.getSlug());
        result.setIcon(category.getIcon());
        return result;
    }

    public static Set<CategoryDto> toDtoWithoutSub(Set<Category> categories) {
        Set<CategoryDto> list = new TreeSet<>();
        for (Category category : categories) {
            list.add(CategoryMapper.toDtoWithoutSub(category));
        }
        return list;
    }

    public static List<CategoryDto> toDtoWithoutSub(List<Category> categories) {
        List<CategoryDto> list = new ArrayList<>();
        for (Category category : categories) {
            list.add(CategoryMapper.toDtoWithoutSub(category));
        }
        return list;
    }

    public static Category toEntity(CategoryDto category) {
        Category result = new Category();
        result.setId(category.getId());
        result.setTitle(category.getTitle());
        result.setSlug(category.getSlug());
        result.setIcon(category.getIcon());
//        if (category.getSubCategories() != null && category.getSubCategories().size() > 0)
//            result.setSubCategories(SubCategoryMapper.toEntity(category.getSubCategories()));
        return result;
    }
}

package com.spring.server.model.mapper;

import com.spring.server.entity.SubCategory;
import com.spring.server.model.dto.SubCategoryDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SubCategoryMapper {
    public static SubCategoryDto toDto(SubCategory category) {
        SubCategoryDto result = new SubCategoryDto();
        result.setId(category.getId());
        result.setTitle(category.getTitle());
        result.setSlug(category.getSlug());
        result.setIcon(category.getIcon());
        return result;
    }

    public static List<SubCategoryDto> toDto(List<SubCategory> categories) {
        List<SubCategoryDto> list = new ArrayList<>();
        for (SubCategory category : categories)
            list.add(SubCategoryMapper.toDto(category));

        return list;
    }

    public static SubCategory toEntity(SubCategoryDto category) {
        SubCategory result = new SubCategory();
        result.setId(category.getId());
        result.setTitle(category.getTitle());
        result.setSlug(category.getSlug());
        result.setIcon(category.getIcon());
        return result;
    }

    public static List<SubCategory> toEntity(List<SubCategoryDto> categories) {
        List<SubCategory> list = new ArrayList<>();
        for (SubCategoryDto category : categories) {
            list.add(SubCategoryMapper.toEntity(category));
        }
        return list;
    }

}

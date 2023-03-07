package com.spring.server.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto extends BaseDto{
    private String title, slug, icon;

    private List<SubCategoryDto> subCategories;

}

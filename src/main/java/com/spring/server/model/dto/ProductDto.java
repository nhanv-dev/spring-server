package com.spring.server.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto extends BaseDto {
    private String name;
    private String slug;
    private Double price;
    private Integer quantity;
    private Integer orderCount;
    private CategoryDto category;
    private SubCategoryDto subCategory;
    private ShopDto shopDto;
    private RatingInfoDto ratingInfo;
    private Set<ProductImageDto> images;

}

package com.spring.server.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDetailDto extends BaseDto {
    private String name;
    private String slug;
    private String description;
    private String shortDescription;
    private String keywords;
    private Double price;
    private Integer quantity;
    private Integer orderCount;
    private CategoryDto category;
    private SubCategoryDto subCategory;
    private ShopDto shop;
    private RatingInfoDto ratingInfo;
    private Set<ReturnPolicyDto> returnPolicies;
    private Set<ProductImageDto> images;
    private Set<ProductAttributeDto> attributes;
    private Set<ProductVariantDto> variants;

}

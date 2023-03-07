package com.spring.server.model.mapper;

import com.spring.server.entity.Product;
import com.spring.server.model.dto.CategoryDto;
import com.spring.server.model.dto.ProductDetailDto;
import com.spring.server.model.dto.ProductDto;
import com.spring.server.model.dto.SubCategoryDto;

public class ProductDetailMapper {
    public static ProductDetailDto toDto(Product product) {
        ProductDetailDto result = new ProductDetailDto();
        result.setId(product.getId());
        result.setName(product.getName());
        result.setSlug(product.getSlug());
        CategoryDto category = new CategoryDto(product.getCategory().getTitle(), product.getCategory().getSlug(), product.getCategory().getIcon(), null);
        category.setId(product.getCategory().getId());
        result.setCategory(category);
        SubCategoryDto subCategory = new SubCategoryDto(product.getCategory().getTitle(), product.getCategory().getSlug(), product.getCategory().getIcon());
        subCategory.setId(product.getSubCategory().getId());
        result.setSubCategory(subCategory);
        result.setDescription(product.getDescription());
        result.setShortDescription(product.getShortDescription());
        result.setOrderCount(product.getOrderCount());
        result.setPrice(product.getPrice());
        result.setQuantity(product.getQuantity());
        return result;
    }


}

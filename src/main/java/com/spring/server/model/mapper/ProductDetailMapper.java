package com.spring.server.model.mapper;

import com.spring.server.model.entity.Product;
import com.spring.server.model.entity.ProductImage;
import com.spring.server.model.dto.*;
import com.spring.server.model.entity.RatingInfo;

import java.util.HashSet;
import java.util.Set;

public class ProductDetailMapper {
    public static ProductDto toDto(Product product) {
        ProductDto result = ProductMapper.toDto(product);

        result.setDescription(product.getDescription());
        result.setShortDescription(product.getShortDescription());
        result.setAttributes(ProductAttributeMapper.toDto(product.getAttributes()));
        result.setVariants(ProductVariantMapper.toDto(product.getVariants()));

        return result;
    }

    public static Product toEntity(ProductDto product) {
        Product result = ProductMapper.toEntity(product);

        result.setDescription(product.getDescription());
        result.setShortDescription(product.getShortDescription());
//        result.setAttributes(ProductAttributeMapper.toEntity(product.getAttributes()));
//        result.setVariants(ProductVariantMapper.toEntity(product.getVariants()));

        result.setRatingInfo(new RatingInfo());
        result.setShop(ShopMapper.toEntity(product.getShop()));

        return result;
    }

}

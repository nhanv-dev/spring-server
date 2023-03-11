package com.spring.server.model.mapper;

import com.spring.server.model.entity.Product;
import com.spring.server.model.entity.ProductImage;
import com.spring.server.model.dto.*;
import com.spring.server.model.entity.ProductVariant;

import java.util.HashSet;
import java.util.Set;

public class ProductDetailMapper {
    public static ProductDetailDto toDto(Product product) {
        ProductDetailDto result = new ProductDetailDto();

        result.setId(product.getId());
        result.setName(product.getName());
        result.setSlug(product.getSlug());
        result.setOrderCount(product.getOrderCount());
        result.setPrice(product.getPrice());
        result.setQuantity(product.getQuantity());
        result.setDescription(product.getDescription());
        result.setShortDescription(product.getShortDescription());

        result.setCategory(CategoryMapper.toDtoWithoutSub(product.getCategory()));
        result.setSubCategory(SubCategoryMapper.toDto(product.getSubCategory()));
        result.setRatingInfo(RatingInfoMapper.toDto(product.getRatingInfo()));
        result.setShop(ShopMapper.toDto(product.getShop()));
        result.setAttributes(ProductAttributeMapper.toDto(product.getAttributes()));
        result.setVariants(ProductVariantMapper.toDto(product.getVariants()));

        Set<ProductImageDto> images = new HashSet<>();
        for (ProductImage image : product.getImages()) images.add(new ProductImageDto(image.getId(), image.getUrl()));
        result.setImages(images);

        return result;
    }


}

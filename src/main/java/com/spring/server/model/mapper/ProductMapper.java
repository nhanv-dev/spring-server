package com.spring.server.model.mapper;

import com.spring.server.model.entity.Product;
import com.spring.server.model.entity.ProductImage;
import com.spring.server.model.dto.*;
import com.spring.server.model.entity.RatingInfo;
import org.springframework.data.domain.Page;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;

public class ProductMapper {
    public static ProductDto toDto(Product product) {
        ProductDto result = new ProductDto();
        result.setId(product.getId());
        result.setName(product.getName());
        result.setSlug(product.getSlug());
        result.setOrderCount(product.getOrderCount());
        result.setPrice(product.getPrice());
        result.setQuantity(product.getQuantity());

        result.setCategory(CategoryMapper.toDtoWithoutSub(product.getCategory()));
        result.setSubCategory(SubCategoryMapper.toDto(product.getSubCategory()));
        result.setRatingInfo(RatingInfoMapper.toDto(product.getRatingInfo()));
        result.setShop(ShopMapper.toDto(product.getShop()));
        result.setDiscount(DiscountMapper.toDto(product.getDiscount()));

        Set<ProductImageDto> images = new TreeSet<>();
        for (ProductImage image : product.getImages()) images.add(new ProductImageDto(image.getId(), image.getUrl()));
        result.setImages(images);

        return result;
    }

    public static Page<ProductDto> toDto(Page<Product> products) {
        return products.map(new Function<Product, ProductDto>() {
            @Override
            public ProductDto apply(Product product) {
                return ProductMapper.toDto(product);
            }
        });
    }


    public static Product toEntity(ProductDto product) {
        Product result = new Product();
        result.setId(product.getId());
        result.setName(product.getName());
        result.setSlug(product.getSlug());
        result.setOrderCount(product.getOrderCount());
        result.setPrice(product.getPrice());
        result.setQuantity(product.getQuantity());

        result.setCategory(CategoryMapper.toEntity(product.getCategory()));
        result.setSubCategory(SubCategoryMapper.toEntity(product.getSubCategory()));
        result.setDiscount(DiscountMapper.toEntity(product.getDiscount()));
        result.setShop(ShopMapper.toEntity(product.getShop()));
        if (product.getRatingInfo() == null)
            result.setRatingInfo(new RatingInfo());
        else
            result.setRatingInfo(RatingInfoMapper.toEntity(product.getRatingInfo()));

        if (product.getImages() != null && product.getImages().size() > 0) {
            Set<ProductImage> images = new HashSet<>();
            for (ProductImageDto image : product.getImages()) {
                ProductImage productImage = new ProductImage();
                productImage.setUrl(image.getUrl());
                productImage.setProduct(result);
                images.add(productImage);
            }
            result.setImages(images);
        }

        return result;
    }

}

package com.spring.server.model.mapper;

import com.spring.server.model.dto.ProductAttributeOptionDto;
import com.spring.server.model.dto.ProductVariantDto;
import com.spring.server.model.entity.Product;
import com.spring.server.model.entity.ProductAttribute;
import com.spring.server.model.entity.ProductAttributeOption;
import com.spring.server.model.entity.ProductVariant;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

@Component
public class ProductVariantMapper {

    public static ProductVariantDto toDto(ProductVariant variant) {
        if (variant == null) return null;
        ProductVariantDto result = new ProductVariantDto();
        result.setId(variant.getId());
        result.setAttributeHash(variant.getAttributeHash());
        result.setQuantity(variant.getQuantity());
        result.setDeleted(variant.isDeleted());
        result.setDeal(DealMapper.toDto(variant.getDeal()));
        result.setOptions(ProductAttributeOptionMapper.toDtos(variant.getOptions()));
        return result;
    }

    public static Set<ProductVariantDto> toDtos(Set<ProductVariant> variants) {
        if (variants == null || variants.isEmpty()) return null;
        Set<ProductVariantDto> list = new TreeSet<>();
        for (ProductVariant variant : variants) list.add(ProductVariantMapper.toDto(variant));
        return list;
    }

    public static ProductVariant toEntity(ProductVariantDto variant, Product product) {
        ProductVariant result = new ProductVariant();
        result.setId(variant.getId());
        result.setAttributeHash(variant.getAttributeHash());
        result.setQuantity(variant.getQuantity());
        result.setDeleted(variant.isDeleted());
        result.setProduct(product);

        result.setOptions(ProductAttributeOptionMapper.toEntities(variant.getOptions(), result, product));
        return result;
    }

    public static Set<ProductVariant> toEntities(Set<ProductVariantDto> variants, Product product) {
        if (variants == null || variants.isEmpty()) return null;
        Set<ProductVariant> result = new HashSet<>();
        for (ProductVariantDto variant : variants) {
            result.add(ProductVariantMapper.toEntity(variant, product));
        }
        return result;
    }
}



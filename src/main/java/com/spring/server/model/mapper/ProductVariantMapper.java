package com.spring.server.model.mapper;

import com.spring.server.model.dto.ProductAttributeOptionDto;
import com.spring.server.model.dto.ProductVariantDto;
import com.spring.server.model.entity.ProductAttributeOption;
import com.spring.server.model.entity.ProductVariant;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class ProductVariantMapper {

    public static ProductVariantDto toDto(ProductVariant variant) {
        ProductVariantDto result = new ProductVariantDto();
        result.setId(variant.getId());
        result.setAttributeHash(variant.getAttributeHash());
        result.setPrice(variant.getPrice());
        result.setQuantity(variant.getQuantity());
        result.setDeleted(variant.isDeleted());
        Set<ProductAttributeOptionDto> options = new HashSet<>();
        for (ProductAttributeOption option : variant.getOptions()) {
            options.add(new ProductAttributeOptionDto(
                    option.getId(), null, option.getName(), option.getValue(), option.getImage(), option.isDeleted()
            ));
        }
        result.setOptions(options);
        return result;
    }

    public static Set<ProductVariantDto> toDto(Set<ProductVariant> variants) {
        Set<ProductVariantDto> list = new HashSet<>();
        for (ProductVariant variant : variants) {
            list.add(ProductVariantMapper.toDto(variant));
        }
        return list;
    }
}



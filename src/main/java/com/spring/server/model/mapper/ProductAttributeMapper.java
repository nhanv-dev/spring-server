package com.spring.server.model.mapper;

import com.spring.server.model.dto.CategoryDto;
import com.spring.server.model.dto.ProductAttributeDto;
import com.spring.server.model.dto.ProductAttributeOptionDto;
import com.spring.server.model.entity.*;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ProductAttributeMapper {
    public static ProductAttributeDto toDto(ProductAttribute attribute) {
        ProductAttributeDto result = new ProductAttributeDto();
        result.setId(attribute.getId());
        result.setName(attribute.getName());
        result.setOptions(new TreeSet<>(ProductAttributeOptionMapper.toDtos(attribute.getOptions())));
        return result;
    }

    public static Set<ProductAttributeDto> toDtos(Set<ProductAttribute> attributes) {
        if (attributes == null) return null;
        Set<ProductAttributeDto> list = new HashSet<>();
        for (ProductAttribute attribute : attributes) {
            list.add(ProductAttributeMapper.toDto(attribute));
        }
        return list;
    }

    public static ProductAttribute toEntity(ProductAttributeDto attribute, Product product) {
        ProductAttribute result = new ProductAttribute();
        result.setId(attribute.getId());
        result.setName(attribute.getName());
        result.setOptions(ProductAttributeOptionMapper.toEntities(attribute.getOptions(), result));
        result.setProduct(product);
        return result;
    }

    public static Set<ProductAttribute> toEntities(Set<ProductAttributeDto> attributes, Product product) {
        if (attributes == null) return null;
        Set<ProductAttribute> list = new HashSet<>();
        for (ProductAttributeDto attribute : attributes) {
            list.add(ProductAttributeMapper.toEntity(attribute, product));
        }
        return list;
    }
}



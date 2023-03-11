package com.spring.server.model.mapper;

import com.spring.server.model.dto.CategoryDto;
import com.spring.server.model.dto.ProductAttributeDto;
import com.spring.server.model.dto.ProductAttributeOptionDto;
import com.spring.server.model.entity.Category;
import com.spring.server.model.entity.ProductAttribute;
import com.spring.server.model.entity.ProductAttributeOption;
import com.spring.server.model.entity.SubCategory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class ProductAttributeMapper {
    public static ProductAttributeDto toDto(ProductAttribute attribute) {
        ProductAttributeDto result = new ProductAttributeDto();
        result.setId(attribute.getId());
        result.setName(attribute.getName());
        Set<ProductAttributeOptionDto> options = new HashSet<>();
        for (ProductAttributeOption option : attribute.getOptions()) {
            options.add(new ProductAttributeOptionDto(
                    option.getId(), result.getId(), option.getName(), option.getValue(), option.getImage(), option.isDeleted()
            ));
        }
        result.setOptions(options);
        return result;
    }

    public static Set<ProductAttributeDto> toDto(Set<ProductAttribute> attributes) {
        Set<ProductAttributeDto> list = new HashSet<>();
        for (ProductAttribute attribute : attributes) {
            list.add(ProductAttributeMapper.toDto(attribute));
        }
        return list;
    }
}



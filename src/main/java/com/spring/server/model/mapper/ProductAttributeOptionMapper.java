package com.spring.server.model.mapper;

import com.spring.server.model.dto.ProductAttributeDto;
import com.spring.server.model.dto.ProductAttributeOptionDto;
import com.spring.server.model.entity.Product;
import com.spring.server.model.entity.ProductAttribute;
import com.spring.server.model.entity.ProductAttributeOption;
import com.spring.server.model.entity.ProductVariant;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

@Component
public class ProductAttributeOptionMapper {
    public static ProductAttributeOptionDto toDto(ProductAttributeOption option) {
        ProductAttributeOptionDto result = new ProductAttributeOptionDto();
        result.setId(option.getId());
        result.setName(option.getName());
        result.setValue(option.getValue());
        result.setImage(option.getImage());
        result.setDeleted(option.isDeleted());
        result.setAttributeId(option.getAttribute().getId());
        return result;
    }

    public static Set<ProductAttributeOptionDto> toDtos(Set<ProductAttributeOption> options) {
        Set<ProductAttributeOptionDto> list = new TreeSet<>();
        for (ProductAttributeOption option : options) {
            list.add(ProductAttributeOptionMapper.toDto(option));
        }
        return list;
    }

    public static ProductAttributeOption toEntity(ProductAttributeOptionDto option, ProductAttribute attribute) {
        ProductAttributeOption result = new ProductAttributeOption();
        result.setId(option.getId());
        result.setName(option.getName());
        result.setValue(option.getValue());
        result.setImage(option.getImage());
        result.setDeleted(option.isDeleted());
        if (attribute != null) result.setAttribute(attribute);
        return result;
    }


    public static ProductAttributeOption toEntity(ProductAttributeOptionDto option, ProductVariant variant, Product product) {
        for (ProductAttribute attribute : product.getAttributes()) {
            for (ProductAttributeOption opt : attribute.getOptions()) {
                if (!opt.getName().equals(option.getName())) continue;
                if (!opt.getValue().equals(option.getValue())) continue;
                ProductAttributeOption result = toEntity(option, attribute);

            }
        }
        return null;
    }

    public static Set<ProductAttributeOption> toEntities(Set<ProductAttributeOptionDto> options, ProductAttribute attribute) {
        Set<ProductAttributeOption> result = new HashSet<>();
        for (ProductAttributeOptionDto option : options) {
            result.add(ProductAttributeOptionMapper.toEntity(option, attribute));
        }
        return result;
    }

    public static Set<ProductAttributeOption> toEntities(Set<ProductAttributeOptionDto> options, ProductVariant variant, Product product) {
        Set<ProductAttributeOption> result = new HashSet<>();
        for (ProductAttributeOptionDto option : options) {
            result.add(ProductAttributeOptionMapper.toEntity(option, variant, product));
        }
        return result;
    }
}



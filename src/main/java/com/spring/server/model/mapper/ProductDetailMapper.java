package com.spring.server.model.mapper;

import com.spring.server.model.entity.*;
import com.spring.server.model.dto.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ProductDetailMapper {
    public static ProductDto toDto(Product product) {
        ProductDto result = ProductMapper.toDto(product);

        result.setDescription(product.getDescription());
        result.setShortDescription(product.getShortDescription());
        result.setReturnPolicies(ReturnPolicyMapper.toDtos(product.getReturnPolicies()));
        result.setDiscounts(DiscountMapper.toDtos(product.getDiscounts()));
        result.setAttributes(ProductAttributeMapper.toDtos(product.getAttributes()));
        result.setVariants(ProductVariantMapper.toDtos(product.getVariants()));

        return result;
    }

    public static Product toEntity(ProductDto product) {
        Product result = ProductMapper.toEntity(product);

        result.setDescription(product.getDescription());
        result.setShortDescription(product.getShortDescription());
        result.setReturnPolicies(ReturnPolicyMapper.toEntities(product.getReturnPolicies()));
        result.setDiscounts(DiscountMapper.toEntities(product.getDiscount(), result));
        result.setAttributes(ProductAttributeMapper.toEntities(product.getAttributes(), result));

        if (product.getVariants() != null && !product.getVariants().isEmpty()) {
            Set<ProductVariant> variants = new HashSet<>();
            for (ProductVariantDto variantDto : product.getVariants()) {
                ProductVariant variant = new ProductVariant();
                variant.setPrice(variantDto.getPrice());
                variant.setSkuUser(variantDto.getSkuUser());
                variant.setAttributeHash(variantDto.getAttributeHash());
                variant.setQuantity(variantDto.getQuantity());
                variant.setProduct(result);
                Set<ProductAttributeOption> options = new HashSet<>();
                for (ProductAttributeOptionDto optionDto : variantDto.getOptions()) {
                    A:
                    for (ProductAttribute attribute : result.getAttributes()) {
                        for (ProductAttributeOption option : attribute.getOptions()) {
                            if (!Objects.equals(option.getName(), optionDto.getName())) continue;
                            if (!Objects.equals(option.getValue(), optionDto.getValue())) continue;
                            if (!Objects.equals(option.getImage(), optionDto.getImage())) continue;
                            options.add(option);
                            break A;
                        }
                    }
                }
                variant.setOptions(options);
                variants.add(variant);
            }
            result.setVariants(variants);
        }

        return result;
    }

}

package com.spring.server.service.implement;

import com.spring.server.entity.Category;
import com.spring.server.entity.Product;
import com.spring.server.model.dto.CategoryDto;
import com.spring.server.model.dto.ProductDetailDto;
import com.spring.server.model.dto.ProductDto;
import com.spring.server.model.mapper.CategoryMapper;
import com.spring.server.model.mapper.ProductMapper;
import com.spring.server.repository.ProductRepo;
import com.spring.server.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public ProductDto findOneById(Long id) {
        Product product = productRepo.findOneById(id);
        return ProductMapper.toDto(product);
    }

    @Override
    public Page<ProductDto> findByOrderByCreatedAt(Pageable pageable) {
        Page<Product> entities = productRepo.findByOrderByCreatedAt(pageable);
        Page<ProductDto> reuslt = entities.map(new Function<Product, ProductDto>() {
            @Override
            public ProductDto apply(Product product) {
                return ProductMapper.toDto(product);
            }
        });
        return reuslt;
    }



}

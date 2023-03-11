package com.spring.server.service.implement;

import com.spring.server.model.entity.Product;
import com.spring.server.model.dto.ProductDetailDto;
import com.spring.server.model.dto.ProductDto;
import com.spring.server.model.mapper.ProductDetailMapper;
import com.spring.server.model.mapper.ProductMapper;
import com.spring.server.repository.ProductRepo;
import com.spring.server.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public Product findOneById(Long id) {
        return productRepo.findOneById(id);
    }

    @Override
    public Product findOneBySlug(String slug) {
        return productRepo.findOneBySlug(slug);
    }


    @Override
    public Page<Product> findByOrderByCreatedAt(Pageable pageable) {
        return productRepo.findByOrderByCreatedAt(pageable);
    }


}

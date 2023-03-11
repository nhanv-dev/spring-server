package com.spring.server.service;


import com.spring.server.model.dto.ProductDetailDto;
import com.spring.server.model.dto.ProductDto;
import com.spring.server.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ProductService {
    Product findOneById(Long id);

    Product findOneBySlug(String slug);

    Page<Product> findByOrderByCreatedAt(Pageable pageable);

}

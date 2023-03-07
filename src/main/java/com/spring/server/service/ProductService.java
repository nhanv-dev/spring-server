package com.spring.server.service;


import com.spring.server.model.dto.ProductDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ProductService {
    ProductDto findOneById(Long id);

    Page<ProductDto> findByOrderByCreatedAt(Pageable pageable);

}

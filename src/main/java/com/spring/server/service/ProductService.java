package com.spring.server.service;


import com.spring.server.model.dto.ProductDto;
import com.spring.server.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ProductService {
    ProductDto findOneById(Long id);

    ProductDto findOneBySlug(String slug);

    Page<ProductDto> findByOrderByCreatedAt(Pageable pageable);

    Page<ProductDto> findByCategorySlug(Pageable pageable, String categorySlug);

    Page<ProductDto> findByShopId(Pageable pageable, Long shopId);

}

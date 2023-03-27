package com.spring.server.service;

import com.spring.server.model.dto.ProductDto;
import com.spring.server.model.entity.Shop;
import com.spring.server.model.dto.ShopDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ShopService {
    ProductDto findProductById(Long id);

    Page<ProductDto> findProductByShopId(Pageable pageable, Long shopId);

    ShopDto findOneById(Long id);
    Shop findById(Long id);
    ShopDto findOneByUserId(Long id);

    ShopDto findOneBySlug(String slug);

    ShopDto save(Shop shop);

    Shop updateShop(Shop currentShop);


    Shop findById(long id);

    ProductDto saveProduct(ProductDto productDto);

    void deleteProduct(Long id);

}

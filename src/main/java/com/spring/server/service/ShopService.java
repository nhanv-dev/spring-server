package com.spring.server.service;

import com.spring.server.model.entity.Shop;
import com.spring.server.model.dto.ShopDto;

public interface ShopService {
    ShopDto findOneById(Long id);
    Shop findById(Long id);
    ShopDto findOneByUserId(Long id);

    ShopDto save(Shop shop);

    Shop updateShop(Shop currentShop);


}

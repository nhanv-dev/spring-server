package com.spring.server.service;

import com.spring.server.model.entity.Shop;
import com.spring.server.model.dto.ShopDto;

public interface ShopService {
    ShopDto findOneById(Long id);

    ShopDto save(Shop shop);
}

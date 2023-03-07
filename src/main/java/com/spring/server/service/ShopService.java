package com.spring.server.service;

import com.spring.server.entity.Shop;
import com.spring.server.entity.User;
import com.spring.server.model.dto.ShopDto;
import com.spring.server.model.dto.UserDto;

import java.util.List;

public interface ShopService {
    ShopDto findOneById(Long id);

}

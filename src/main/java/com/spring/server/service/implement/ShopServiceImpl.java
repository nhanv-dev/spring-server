package com.spring.server.service.implement;

import com.spring.server.entity.Shop;
import com.spring.server.model.dto.ShopDto;
import com.spring.server.model.mapper.ShopMapper;
import com.spring.server.repository.ShopRepo;
import com.spring.server.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopRepo shopRepo;


    @Override
    public ShopDto findOneById(Long id) {
        return ShopMapper.toDto(shopRepo.findOneById(id));
    }
}

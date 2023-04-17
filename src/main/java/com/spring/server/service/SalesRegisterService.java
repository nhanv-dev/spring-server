package com.spring.server.service;

import com.spring.server.model.constant.ESalesRegisterStatus;
import com.spring.server.model.dto.SalesRegisterDto;
import com.spring.server.model.dto.ShopDto;
import com.spring.server.model.entity.Shop;
import org.springframework.data.domain.Page;

public interface SalesRegisterService {

    SalesRegisterDto findOneByUserId(Long userId);

    Page<SalesRegisterDto> findAll(int page, int size);

    Page<SalesRegisterDto> findAllByStatus(int page, int size, ESalesRegisterStatus status);

    SalesRegisterDto confirm(Long id);

    SalesRegisterDto save(SalesRegisterDto salesRegisterDto);


}

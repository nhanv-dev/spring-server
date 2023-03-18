package com.spring.server.service;

import com.spring.server.model.dto.ReturnPolicyDto;
import com.spring.server.model.dto.UserDto;
import com.spring.server.model.entity.User;

import java.util.List;

public interface ReturnPolicyService {

    List<ReturnPolicyDto> findAll();

}

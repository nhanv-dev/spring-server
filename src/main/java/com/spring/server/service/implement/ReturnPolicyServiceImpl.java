package com.spring.server.service.implement;

import com.spring.server.model.dto.ReturnPolicyDto;
import com.spring.server.model.dto.UserDto;
import com.spring.server.model.entity.ReturnPolicy;
import com.spring.server.model.entity.User;
import com.spring.server.model.mapper.ReturnPolicyMapper;
import com.spring.server.model.mapper.UserMapper;
import com.spring.server.repository.ReturnPolicyRepo;
import com.spring.server.repository.UserRepo;
import com.spring.server.service.ReturnPolicyService;
import com.spring.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ReturnPolicyServiceImpl implements ReturnPolicyService {
    @Autowired
    private ReturnPolicyRepo returnPolicyRepo;

    @Override
    public List<ReturnPolicyDto> findAll() {
        List<ReturnPolicy> list = returnPolicyRepo.findAll();
        return new ArrayList<>(ReturnPolicyMapper.toDtos(list));
    }
}

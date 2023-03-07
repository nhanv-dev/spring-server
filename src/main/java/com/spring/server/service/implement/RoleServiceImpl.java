package com.spring.server.service.implement;

import com.spring.server.entity.Category;
import com.spring.server.entity.ERole;
import com.spring.server.entity.Role;
import com.spring.server.model.dto.CategoryDto;
import com.spring.server.model.mapper.CategoryMapper;
import com.spring.server.repository.CategoryRepo;
import com.spring.server.repository.RoleRepo;
import com.spring.server.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Component
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepo roleRepo;

    @Override
    public Role findOneByType(ERole type) {
        return roleRepo.findOneByType(type);
    }
}

package com.spring.server.service;

import com.spring.server.entity.ERole;
import com.spring.server.entity.Role;
import com.spring.server.model.dto.CategoryDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface RoleService {

    Role findOneByType(ERole type);

}

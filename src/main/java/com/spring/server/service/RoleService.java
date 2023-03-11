package com.spring.server.service;

import com.spring.server.model.entity.ERole;
import com.spring.server.model.entity.Role;

public interface RoleService {

    Role findOneByType(ERole type);

}

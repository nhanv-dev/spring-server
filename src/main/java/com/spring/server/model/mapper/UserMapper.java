package com.spring.server.model.mapper;

import com.spring.server.entity.Role;
import com.spring.server.entity.User;
import com.spring.server.model.dto.RoleDto;
import com.spring.server.model.dto.UserDto;

import java.util.ArrayList;
import java.util.HashSet;

public class UserMapper {
    public static UserDto toDto(User user) {
        UserDto result = new UserDto();
        result.setId(user.getId());
        result.setName(user.getName());
        result.setEmail(user.getEmail());
        result.setPhoneNumber(user.getPhoneNumber());
        result.setRoles(new HashSet<>());
        for (Role role : user.getRoles()) {
            RoleDto roleDto = new RoleDto(role.getType().name());
            roleDto.setId(role.getId());
            result.getRoles().add(roleDto);
        }
        return result;
    }

    public static User toEntity(UserDto user) {
        User result = new User();
        result.setId(user.getId());
        result.setName(user.getName());
        result.setPassword(user.getPassword());
        result.setEmail(user.getEmail());
        result.setPhoneNumber(user.getPhoneNumber());
        return result;
    }


}

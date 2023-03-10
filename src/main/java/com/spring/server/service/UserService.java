package com.spring.server.service;

import com.spring.server.model.entity.User;
import com.spring.server.model.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto findOneById(Long id);


    User findOneByEmail(String email);

    List<User> findAll();

    Boolean existsByEmail(String email);


    UserDto save(User user);

}

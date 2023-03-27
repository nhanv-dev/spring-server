package com.spring.server.service;

import com.spring.server.model.dto.UserAddressDto;
import com.spring.server.model.entity.User;
import com.spring.server.model.dto.UserDto;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserService {
    User findById(Long id);

    User findOneByEmail(String email);

    UserDto findOneById(Long id);

    Set<UserAddressDto> findAddressByUserId(Long userId);

    Boolean existsByEmail(String email);

    UserDto save(User user);

    void update(User currentUser);

}

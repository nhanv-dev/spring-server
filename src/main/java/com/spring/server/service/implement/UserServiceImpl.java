package com.spring.server.service.implement;

import com.spring.server.model.entity.User;
import com.spring.server.model.dto.UserDto;
import com.spring.server.model.mapper.UserMapper;
import com.spring.server.repository.UserRepo;
import com.spring.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userEntityRepo;

    @Override
    public UserDto findOneById(Long id) {
        Optional<User> list = userEntityRepo.findById(id);
        return UserMapper.toDto(list.get());
    }
    
    @Override
    public User findOneByEmail(String email) {
        return userEntityRepo.findOneByEmail(email);
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Boolean existsByEmail(String email) {
        return userEntityRepo.existsByEmail(email);
    }


    @Override
    public UserDto save(User user) {
        User userDto = userEntityRepo.save(user);
        return UserMapper.toDto(userDto);
    }
}

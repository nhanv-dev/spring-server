package com.spring.server.service.implement;

import com.spring.server.model.dto.UserAddressDto;
import com.spring.server.model.dto.UserDto;
import com.spring.server.model.entity.User;
import com.spring.server.model.entity.UserAddress;
import com.spring.server.model.mapper.UserAddressMapper;
import com.spring.server.model.mapper.UserMapper;
import com.spring.server.repository.UserAddressRepo;
import com.spring.server.repository.UserRepo;
import com.spring.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepo userEntityRepo;
    @Autowired
    private UserAddressRepo userAddressRepo;

    @Override
    public User findById(Long id) {
        Optional<User> list = userEntityRepo.findById(id);
        return list.get();
    }

    @Override
    public UserDto findOneById(Long id) {
        return UserMapper.toDto(userEntityRepo.findById(id).get());
    }

    @Override
    public Set<UserAddressDto> findAddressByUserId(Long userId) {
        List<UserAddress> list = userAddressRepo.findAllByUser_Id(userId);
        return UserAddressMapper.toDtos(list);
    }

    @Override
    public User findOneByEmail(String email) {
        return userEntityRepo.findOneByEmail(email);
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

    @Override
    public void update(User currentUser) {
        userEntityRepo.save(currentUser);
    }

}

package com.spring.server.repository;

import com.spring.server.model.entity.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface UserAddressRepo extends JpaRepository<UserAddress, Long> {
    @Query()
    List<UserAddress> findAllByUser_Id(Long userId);
}
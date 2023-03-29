package com.spring.server.repository;

import com.spring.server.model.entity.UserAddress;
import org.hibernate.annotations.SQLDelete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface UserAddressRepo extends JpaRepository<UserAddress, Long> {
    @Query()
    UserAddress findOneById(Long id);

    @Query()
    List<UserAddress> findAllByUser_Id(Long userId);
    @Modifying
    @Query(value = "UPDATE UserAddress u set u.isDefault = false WHERE u.user.id = :id")
    void updateDefaultStatus(Long id);
    @Modifying
    @Query(value = "UPDATE UserAddress u set u.isDeleted = true WHERE u.id = :id")
    void deleteById(Long id);
}
package com.spring.server.model.mapper;

import com.spring.server.model.dto.CartDto;
import com.spring.server.model.dto.UserAddressDto;
import com.spring.server.model.dto.UserDto;
import com.spring.server.model.entity.Cart;
import com.spring.server.model.entity.UserAddress;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Component
public class UserAddressMapper {
    public static UserAddressDto toDto(UserAddress userAddress) {
        UserAddressDto result = new UserAddressDto();
        result.setId(userAddress.getId());
        result.setUserId(userAddress.getUser().getId());
        result.setCustomerName(userAddress.getCustomerName());
        result.setEmail(userAddress.getEmail());
        result.setPhoneNumber(userAddress.getPhoneNumber());
        result.setAddressDetail(userAddress.getAddressDetail());
        result.setCity(userAddress.getCity());
        result.setDistrict(userAddress.getDistrict());
        result.setWards(userAddress.getWards());
        result.setCreatedAt(userAddress.getCreatedAt());
        result.setUpdatedAt(userAddress.getUpdatedAt());
        return result;
    }

    public static Set<UserAddressDto> toDtos(List<UserAddress> userAddresses) {
        if (userAddresses == null || userAddresses.isEmpty()) return null;
        Set<UserAddressDto> result = new TreeSet<>();
        for (UserAddress userAddress : userAddresses) result.add(toDto(userAddress));
        return result;
    }

    public static Set<UserAddressDto> toDtos(Set<UserAddress> userAddresses) {
        if (userAddresses == null || userAddresses.isEmpty()) return null;
        Set<UserAddressDto> result = new TreeSet<>();
        for (UserAddress userAddress : userAddresses) result.add(toDto(userAddress));
        return result;
    }

    public static UserAddress toEntity(UserAddressDto userAddress) {
        UserAddress result = new UserAddress();
        result.setId(userAddress.getId());
        result.setCustomerName(userAddress.getCustomerName());
        result.setEmail(userAddress.getEmail());
        result.setPhoneNumber(userAddress.getPhoneNumber());
        result.setAddressDetail(userAddress.getAddressDetail());
        result.setCity(userAddress.getCity());
        result.setDistrict(userAddress.getDistrict());
        result.setWards(userAddress.getWards());
        result.setCreatedAt(userAddress.getCreatedAt());
        result.setUpdatedAt(userAddress.getUpdatedAt());
        return result;
    }
}
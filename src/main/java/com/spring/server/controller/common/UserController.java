package com.spring.server.controller.common;

import com.spring.server.model.dto.UserAddressDto;
import com.spring.server.model.entity.User;
import com.spring.server.model.dto.UserDto;
import com.spring.server.model.entity.UserAddress;
import com.spring.server.model.mapper.UserMapper;
import com.spring.server.payload.response.MessageResponse;
import com.spring.server.service.UserService;
import org.apache.catalina.security.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Objects;
import java.util.Set;


@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable(value = "id") Long id) {
        UserDto user = userService.findOneById(id);
        return ResponseEntity.ok(user);
    }


    @GetMapping("/email")
    public ResponseEntity<?> getUserByEmail(@RequestParam String email) {
        User user = userService.findOneByEmail(email);
        return ResponseEntity.ok(UserMapper.toDto(user));
    }

    @PutMapping("/user-profile/{id}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<?> updateUser(@PathVariable("id") Long id, @RequestBody UserDto userDto) {
        System.out.println(userDto.toString());
        User currentUser = userService.findById(id);
        currentUser.setName(userDto.getName());
        currentUser.setPhoneNumber(userDto.getPhoneNumber());
        userService.update(currentUser);
        return ResponseEntity.ok(new MessageResponse("User saved successfully!!"));
    }

    @GetMapping("/{id}/addresses")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<?> getAddressByUserId(@PathVariable(value = "id") Long id) {
        Set<UserAddressDto> address = userService.findAddressByUserId(id);
        if (address.size() == 0) return ResponseEntity.ok(new MessageResponse("User address is empty"));
        return ResponseEntity.ok(address);
    }

    @PostMapping("/{id}/addresses")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<?> saveAddress(
            @PathVariable("id") Long id,
            Authentication authentication,
            @RequestBody UserAddressDto userAddressDto
    ) {
        User user = userService.findOneByEmail(authentication.getName());
        if (!Objects.equals(user.getId(), id))
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new MessageResponse("User saved successfully!!"));
        userAddressDto.setUserId(id);
        userAddressDto = userService.saveAddress(userAddressDto);
        return ResponseEntity.ok(userAddressDto);
    }

    @PutMapping("/{id}/addresses/{addressId}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<?> updateAddress(
            Authentication authentication,
            @PathVariable Long id,
            @PathVariable Long addressId,
            @RequestBody UserAddressDto userAddressDto
    ) {
        User user = userService.findOneByEmail(authentication.getName());
        if (!Objects.equals(user.getId(), id))
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new MessageResponse("User saved successfully!!"));
        UserAddressDto address = userService.findAddressById(addressId);
        if (address == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MessageResponse("Don't find user address"));
        userAddressDto.setUserId(id);
        userAddressDto = userService.updateAddress(userAddressDto);
        return ResponseEntity.ok(userAddressDto);
    }

    @DeleteMapping("/{id}/addresses/{addressId}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<?> deleteAddress(
            Authentication authentication,
            @PathVariable Long id,
            @PathVariable Long addressId
    ) {
        User user = userService.findOneByEmail(authentication.getName());
        if (!Objects.equals(user.getId(), id))
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new MessageResponse("User saved successfully!!"));
        userService.deleteAddress(addressId);
        return ResponseEntity.ok(new MessageResponse("Deleted user address!!"));
    }
}


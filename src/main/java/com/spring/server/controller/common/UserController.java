package com.spring.server.controller.common;

import com.spring.server.model.entity.User;
import com.spring.server.model.dto.UserDto;
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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;


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
    public ResponseEntity<?> updateUser(@PathVariable("id") long id, @RequestBody UserDto userDto) {
        System.out.println(userDto.toString());
        User currentUser = userService.findById(id);

        System.out.println(currentUser.getId());
        currentUser.setName(userDto.getName());
        currentUser.setPhoneNumber(userDto.getPhoneNumber());

        userService.updateUser(currentUser);

        return ResponseEntity.ok(new MessageResponse("User saved successfully!!"));

    }
}


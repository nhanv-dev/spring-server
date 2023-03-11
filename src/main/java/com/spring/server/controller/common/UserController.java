package com.spring.server.controller.common;

import com.spring.server.model.entity.User;
import com.spring.server.model.dto.UserDto;
import com.spring.server.model.mapper.UserMapper;
import com.spring.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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
}


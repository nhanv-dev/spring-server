package com.spring.server.controller.common;

import com.spring.server.entity.ERole;
import com.spring.server.entity.Role;
import com.spring.server.entity.User;
import com.spring.server.payload.request.LoginRequest;
import com.spring.server.payload.request.SalesRegisterRequest;
import com.spring.server.payload.request.SignUpRequest;
import com.spring.server.payload.response.JwtResponse;
import com.spring.server.payload.response.MessageResponse;
import com.spring.server.security.jwt.JwtUtils;
import com.spring.server.security.services.UserDetailsImpl;
import com.spring.server.service.RoleService;
import com.spring.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/api/sales-register")
public class SalesRegisterController {
    @Autowired
    private UserService userService;

    @PostMapping("")
    public ResponseEntity<?> authenticateUser(Authentication authentication, @Valid @RequestBody SalesRegisterRequest salesRegisterRequest) {
        System.out.println("authen" + authentication.getName());
        return ResponseEntity.ok(salesRegisterRequest);
    }


}


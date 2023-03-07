package com.spring.server.controller.common;

import com.spring.server.entity.ERole;
import com.spring.server.entity.Role;
import com.spring.server.entity.User;
import com.spring.server.model.dto.UserDto;
import com.spring.server.model.mapper.UserMapper;
import com.spring.server.payload.request.LoginRequest;
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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/sign-in")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).toList();
        return ResponseEntity.ok(
                new JwtResponse(jwt, userDetails.getId(), userDetails.getEmail(), userDetails.getName(), roles)
        );
    }

    @PostMapping("/sign-up")
    public ResponseEntity<?> register(@Valid @RequestBody SignUpRequest signUpRequest) {
        if (userService.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
        }
        User user = new User(signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()),
                signUpRequest.getName(),
                signUpRequest.getPhoneNumber());

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();
        if (strRoles == null) {
            Role userRole = roleService.findOneByType(ERole.ROLE_USER);
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleService.findOneByType(ERole.ROLE_ADMIN);
                        if (adminRole == null) throw new RuntimeException("Error: Role is not found.");
                        roles.add(adminRole);

                        break;
                    case "shop":
                        Role shopRole = roleService.findOneByType(ERole.ROLE_SHOP);
                        if (shopRole == null) throw new RuntimeException("Error: Role is not found.");
                        roles.add(shopRole);

                        break;
                    default:
                        Role userRole = roleService.findOneByType(ERole.ROLE_USER);
                        if (userRole == null) throw new RuntimeException("Error: Role is not found.");
                        roles.add(userRole);
                }
            });
        }
        user.setRoles(roles);
        userService.save(user);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}


package com.spring.server.controller.admin;

import com.spring.server.payload.response.MessageResponse;
import com.spring.server.service.ShopService;
import com.spring.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/admin/register")
public class RegisterController {
    @Autowired
    private UserService userService;
    @Autowired
    private ShopService shopService;

    @GetMapping("")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> registerSales(Authentication authentication) {

        return ResponseEntity.ok(new MessageResponse("Shop registered successfully!"));
    }


}


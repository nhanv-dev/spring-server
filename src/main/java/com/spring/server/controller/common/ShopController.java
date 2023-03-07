package com.spring.server.controller.common;

import com.spring.server.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shops")
public class ShopController {
    @Autowired
    private ShopService shopService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getByShopId(@PathVariable(value = "id") Long id) {

        return ResponseEntity.ok(shopService.findOneById(id));
    }


}


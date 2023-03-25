package com.spring.server.controller.common;

import com.spring.server.model.dto.ShopDto;
import com.spring.server.model.dto.UserDto;
import com.spring.server.model.entity.Shop;
import com.spring.server.payload.response.MessageResponse;
import com.spring.server.security.jwt.JwtUtils;
import com.spring.server.service.ShopService;
import com.spring.server.util.SlugGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shops")
public class ShopController {
    @Autowired
    private ShopService shopService;

    @Autowired
    JwtUtils jwtUtils;

    @GetMapping("/{id}")
    public ResponseEntity<?> getByShopId(@PathVariable(value = "id") Long id) {

        return ResponseEntity.ok(shopService.findOneById(id));
    }

    @PutMapping("/shop/{id}")
    @PreAuthorize("hasRole('ROLE_SHOP')")
    public ResponseEntity<?> updateShop(@PathVariable("id") long id, @RequestBody ShopDto shopDto){
        Shop currentShop = shopService.findById(id);

        currentShop.setShopName(shopDto.getShopName());
        currentShop.setEmail(shopDto.getShopEmail());
        currentShop.setPhoneNumber(shopDto.getShopPhone());
        currentShop.setShopSlogan(shopDto.getShopSlogan());
        currentShop.setShopLogo(shopDto.getShopLogo());
        currentShop.setShopBackground(shopDto.getShopBackground());
        currentShop.setSlug(SlugGenerator.toSlug(currentShop.getShopName() + "-" + id));

        shopService.updateShop(currentShop);
        return ResponseEntity.ok(new MessageResponse("Update Shop successful"));

    }


}


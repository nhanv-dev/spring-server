package com.spring.server.controller.common;

import com.spring.server.model.entity.RatingInfo;
import com.spring.server.model.entity.Shop;
import com.spring.server.model.entity.User;
import com.spring.server.payload.request.SalesRegisterRequest;
import com.spring.server.payload.response.MessageResponse;
import com.spring.server.service.ShopService;
import com.spring.server.service.UserService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/sales-register")
public class SalesRegisterController {
    @Autowired
    private UserService userService;
    @Autowired
    private ShopService shopService;

    @PostMapping("")
    public ResponseEntity<?> authenticateUser(Authentication authentication, @Valid @RequestBody SalesRegisterRequest req) {
        User user = userService.findOneByEmail(authentication.getName());

        Shop shop = new Shop();
        shop.setUser(user);
        shop.setRatingInfo(new RatingInfo());
        shop.setShopName(req.getShopName());
        shop.setPhoneNumber(req.getPhoneNumber());
        shop.setEmail(req.getEmail());
        shop.setWarehouseRegionName(req.getWarehouse());
        shop.setCity(req.getCity());
        shop.setDistrict(req.getDistrict());
        shop.setWards(req.getWards());
        shop.setAddressDetail(req.getAddress());

        shopService.save(shop);
        return ResponseEntity.ok(new MessageResponse("Shop registered successfully!"));
    }


}


package com.spring.server.controller.common;

import com.spring.server.model.dto.ProductDto;
import com.spring.server.model.dto.ShopDto;
import com.spring.server.service.ProductService;
import com.spring.server.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/search")
public class SearchController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ShopService shopService;

    @GetMapping("/search-product")
    public ResponseEntity<Page<ProductDto>> searchProducts(@RequestParam("name") String name, Integer page) {
        Pageable pageable = PageRequest.of(0, 30);
        Page<ProductDto> products = productService.searchProducts(pageable, name);
        return ResponseEntity.ok(products);
    }

    @GetMapping("/search-shop")
    public ResponseEntity<ShopDto> searchShops(@RequestParam("name") String name) {
        ShopDto shops = shopService.searchShop(name);
        return ResponseEntity.ok(shops);
    }


}

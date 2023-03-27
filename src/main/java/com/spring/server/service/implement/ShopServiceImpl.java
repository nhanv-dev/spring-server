package com.spring.server.service.implement;

import com.spring.server.model.dto.ProductDto;
import com.spring.server.model.dto.ShopDto;
import com.spring.server.model.entity.*;
import com.spring.server.model.mapper.ProductDetailMapper;
import com.spring.server.model.mapper.ProductMapper;
import com.spring.server.model.mapper.ShopMapper;
import com.spring.server.repository.*;
import com.spring.server.service.ShopService;
import com.spring.server.util.SlugGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;


@Component
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopRepo shopRepo;
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RoleRepo roleRepo;
    @Autowired
    private RatingInfoRepo ratingInfoRepo;

    @Override
    public ProductDto findProductById(Long id) {
        Product product = productRepo.findOneById(id);
        if (product == null) return null;
        return ProductDetailMapper.toDto(product);
    }

    @Override
    public Page<ProductDto> findProductByShopId(Pageable pageable, Long shopId) {
        return ProductMapper.toDtos(productRepo.findAllByShop_Id(pageable, shopId));
    }

    @Override
    public ShopDto findOneById(Long id) {
        return ShopMapper.toDto(shopRepo.findOneById(id));
    }
    @Override
    public Shop findById(Long id) {
        Optional<Shop> list = shopRepo.findById(id);
        return list.get();
    }
    @Override
    public ShopDto findOneByUserId(Long id) {
        return ShopMapper.toDto(shopRepo.findOneByUserId(id));
    }

    @Override
    public ShopDto findOneBySlug(String slug) {
        return ShopMapper.toDto(shopRepo.findOneBySlug(slug));
    }

    @Override
    public ShopDto save(Shop shop) {
        RatingInfo ratingInfo = ratingInfoRepo.save(new RatingInfo());
        shop.setRatingInfo(ratingInfo);
        Shop savedShop = shopRepo.save(shop);
        savedShop.setSlug(SlugGenerator.toSlug(savedShop.getShopName() + "-" + savedShop.getId()));
        savedShop = shopRepo.save(savedShop);

        User user = shop.getUser();
        Set<Role> roles = user.getRoles();
        roles.add(roleRepo.findOneByType(ERole.ROLE_SHOP));
        user.setRoles(roles);
        userRepo.save(user);
        return ShopMapper.toDto(savedShop);
    }

    @Override
    public Shop updateShop(Shop currentShop) {
        Shop shop = shopRepo.save(currentShop);
        return shop;
    }


    @Override
    public Shop findById(long id) {
        Optional<Shop> list = shopRepo.findById(id);
        return list.get();
    }

    @Override
    @Transactional
    public ProductDto saveProduct(ProductDto productDto) {
        Product product = ProductDetailMapper.toEntity(productDto);
        RatingInfo ratingInfo = ratingInfoRepo.save(new RatingInfo());
        product.setRatingInfo(ratingInfo);
        product = productRepo.save(product);
        product.setSlug(SlugGenerator.toSlug(product.getName() + "-" + product.getId()));
        product = productRepo.save(product);
        return ProductDetailMapper.toDto(product);
    }

    @Override
    @Transactional
    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
    }

}

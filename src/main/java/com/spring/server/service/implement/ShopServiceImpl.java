package com.spring.server.service.implement;

import com.spring.server.model.dto.ShopDto;
import com.spring.server.model.entity.*;
import com.spring.server.model.mapper.ShopMapper;
import com.spring.server.repository.RatingInfoRepo;
import com.spring.server.repository.RoleRepo;
import com.spring.server.repository.ShopRepo;
import com.spring.server.repository.UserRepo;
import com.spring.server.service.ShopService;
import com.spring.server.util.SlugGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;


@Component
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopRepo shopRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RoleRepo roleRepo;
    @Autowired
    private RatingInfoRepo ratingInfoRepo;

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


}

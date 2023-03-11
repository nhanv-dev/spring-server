package com.spring.server.service.implement;

import com.spring.server.model.entity.ERole;
import com.spring.server.model.entity.Role;
import com.spring.server.model.entity.Shop;
import com.spring.server.model.entity.User;
import com.spring.server.model.dto.ShopDto;
import com.spring.server.model.mapper.ShopMapper;
import com.spring.server.repository.RoleRepo;
import com.spring.server.repository.ShopRepo;
import com.spring.server.repository.UserRepo;
import com.spring.server.service.ShopService;
import com.spring.server.util.SlugGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;


@Component
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopRepo shopRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RoleRepo roleRepo;

    @Override
    public ShopDto findOneById(Long id) {
        return ShopMapper.toDto(shopRepo.findOneById(id));
    }

    @Override
    public ShopDto save(Shop shop) {
        Shop savedShop = shopRepo.saveAndFlush(shop);
        savedShop.setSlug(SlugGenerator.toSlug(savedShop.getShopName() + "-" + savedShop.getId()));
        savedShop = shopRepo.saveAndFlush(savedShop);

        User user = shop.getUser();
        Set<Role> roles = user.getRoles();
        roles.add(roleRepo.findOneByType(ERole.ROLE_SHOP));
        user.setRoles(roles);
        userRepo.saveAndFlush(user);
        return ShopMapper.toDto(savedShop);
    }
}

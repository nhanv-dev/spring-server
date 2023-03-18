package com.spring.server.service.implement;

import com.spring.server.model.dto.ProductAttributeOptionDto;
import com.spring.server.model.dto.ProductVariantDto;
import com.spring.server.model.entity.*;
import com.spring.server.model.dto.ProductDto;
import com.spring.server.model.mapper.ProductDetailMapper;
import com.spring.server.model.mapper.ProductMapper;
import com.spring.server.repository.DiscountRepo;
import com.spring.server.repository.ProductRepo;
import com.spring.server.repository.RatingInfoRepo;
import com.spring.server.service.ProductService;
import com.spring.server.util.SlugGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private RatingInfoRepo ratingInfoRepo;
    @Autowired
    private DiscountRepo discountRepo;

    @Override
    public ProductDto findOneById(Long id) {
        return ProductDetailMapper.toDto(productRepo.findOneById(id));
    }

    @Override
    public ProductDto findOneBySlug(String slug) {
        return ProductDetailMapper.toDto(productRepo.findOneBySlug(slug));
    }


    @Override
    public Page<ProductDto> findByOrderByCreatedAt(Pageable pageable) {
        return ProductMapper.toDtos(productRepo.findByOrderByCreatedAtAsc(pageable));
    }

    @Override
    @Transactional
    public ProductDto save(ProductDto productDto) {
        Product product = ProductDetailMapper.toEntity(productDto);
        RatingInfo ratingInfo = ratingInfoRepo.save(new RatingInfo());
        product.setRatingInfo(ratingInfo);
        product = productRepo.save(product);
        product.setSlug(SlugGenerator.toSlug(product.getName() + "-" + product.getId()));
        product = productRepo.save(product);
        return ProductDetailMapper.toDto(product);
    }


}

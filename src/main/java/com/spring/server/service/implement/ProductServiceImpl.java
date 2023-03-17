package com.spring.server.service.implement;

import com.spring.server.model.entity.Discount;
import com.spring.server.model.entity.Product;
import com.spring.server.model.dto.ProductDto;
import com.spring.server.model.entity.RatingInfo;
import com.spring.server.model.mapper.ProductDetailMapper;
import com.spring.server.model.mapper.ProductMapper;
import com.spring.server.repository.DiscountRepo;
import com.spring.server.repository.ProductRepo;
import com.spring.server.repository.RatingInfoRepo;
import com.spring.server.service.ProductService;
import com.spring.server.util.SlugGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

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
        return ProductMapper.toDto(productRepo.findByOrderByCreatedAt(pageable));
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        Product product = ProductDetailMapper.toEntity(productDto);
        RatingInfo ratingInfo = ratingInfoRepo.save(product.getRatingInfo());
        Discount discount = discountRepo.save(product.getDiscount());
        product.setDiscount(discount);
        product.setRatingInfo(ratingInfo);
        product = productRepo.save(product);
        product.setSlug(SlugGenerator.toSlug(product.getName() + "-" + product.getId()));
        product = productRepo.save(product);
        return ProductDetailMapper.toDto(product);
    }


}

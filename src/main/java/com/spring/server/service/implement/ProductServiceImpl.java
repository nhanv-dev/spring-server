package com.spring.server.service.implement;

import com.spring.server.model.entity.*;
import com.spring.server.model.dto.ProductDto;
import com.spring.server.model.mapper.ProductDetailMapper;
import com.spring.server.model.mapper.ProductMapper;
import com.spring.server.repository.DealRepo;
import com.spring.server.repository.ProductRepo;
import com.spring.server.repository.RatingInfoRepo;
import com.spring.server.service.ProductService;
import com.spring.server.util.SlugGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private RatingInfoRepo ratingInfoRepo;
    @Autowired
    private DealRepo discountRepo;

    @Override
    public ProductDto findOneById(Long id) {
        Product product = productRepo.findOneById(id);
        if (product == null) return null;
        return ProductDetailMapper.toDto(product);
    }

    @Override
    public ProductDto findOneBySlug(String slug) {
        Product product = productRepo.findOneBySlug(slug);
        if (product == null) return null;
        return ProductDetailMapper.toDto(product);
    }

    @Override
    public Page<ProductDto> findByOrderByCreatedAt(Pageable pageable) {
        return ProductMapper.toDtos(productRepo.findAllByOrderByCreatedAtDesc(pageable));
    }

    @Override
    public Page<ProductDto> findByCategorySlug(Pageable pageable, String categorySlug) {
        return ProductMapper.toDtos(productRepo.findAllByCategory_SlugOrSubCategory_Slug(pageable, categorySlug, categorySlug));
    }

    @Override
    public Page<ProductDto> findByShopId(Pageable pageable, Long shopId) {
        return ProductMapper.toDtos(productRepo.findAllByShop_Id(pageable, shopId));
    }

    @Override
    public Page<ProductDto> findTopByShopId(Long shopId, Long top) {
        return null;
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

    @Override
    @Transactional
    public void delete(Long id) {
        productRepo.deleteById(id);
    }


}

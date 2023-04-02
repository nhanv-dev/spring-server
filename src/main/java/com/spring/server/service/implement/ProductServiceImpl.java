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
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private RatingInfoRepo ratingInfoRepo;
    @Autowired
    private DealRepo discountRepo;
    @Autowired
    private EntityManager entityManager;

    @Override
    public ProductDto findOneById(Long id) {
        Product product = productRepo.findOneByIdAndIsPublicAndIsDeleted(id, true, false);
        if (product == null) return null;
        return ProductDetailMapper.toDto(product);
    }

    @Override
    public ProductDto findOneBySlug(String slug) {
        Product product = productRepo.findOneBySlugAndIsPublicAndIsDeleted(slug, true, false);
        if (product == null) return null;
        return ProductDetailMapper.toDto(product);
    }

    @Override
    public Page<ProductDto> findByOrderByCreatedAt(Pageable pageable) {
        return ProductMapper.toDtos(productRepo.findAllByIsPublicAndIsDeleted(pageable, true, false));
    }

    @Override
    public Page<ProductDto> findByCategorySlug(Pageable pageable, String categorySlug) {
        return ProductMapper.toDtos(productRepo.findAllByCategory(pageable, true, categorySlug, categorySlug));
    }

    @Override
    public Page<ProductDto> findByShopId(Pageable pageable, Long shopId) {
        return ProductMapper.toDtos(productRepo.findAllByShop_IdAndIsPublicAndIsDeleted(pageable, shopId, true, false));
    }


}

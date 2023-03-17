package com.spring.server.service.implement;

import com.spring.server.model.entity.Category;
import com.spring.server.model.entity.SubCategory;
import com.spring.server.model.dto.CategoryDto;
import com.spring.server.model.dto.SubCategoryDto;
import com.spring.server.model.mapper.CategoryMapper;
import com.spring.server.model.mapper.SubCategoryMapper;
import com.spring.server.repository.CategoryRepo;
import com.spring.server.repository.SubCategoryRepo;
import com.spring.server.util.SlugGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Component
public class CategoryServiceImpl implements com.spring.server.service.CategoryService {

    @Autowired
    private CategoryRepo categoryEntityRepo;

    @Autowired
    private SubCategoryRepo subCategoryRepo;

    @Override
    public CategoryDto findOneById(long id) {
        Optional<Category> optional = categoryEntityRepo.findById(id);
        if (optional.isEmpty()) return null;
        return CategoryMapper.toDto(optional.orElse(null));
    }

    @Override
    public List<CategoryDto> findAll() {
        List<Category> list = categoryEntityRepo.findAll();
        for (Category category : list) {
            if (category.getSlug() != null) break;
            category.setSlug(SlugGenerator.toSlug(category.getTitle()));
            for (SubCategory sub : category.getSubCategories()) {
                sub.setSlug(SlugGenerator.toSlug(sub.getTitle()));
            }
            categoryEntityRepo.save(category);
        }
        return CategoryMapper.toDto(list);
    }

    @Override
    public List<CategoryDto> findAllWithoutSub() {
        List<Category> list = categoryEntityRepo.findAll();
        return CategoryMapper.toDtoWithoutSub(list);
    }

    @Override
    public List<CategoryDto> findByCategoryId(long id) {
        return null;
    }

    @Override
    public Page<CategoryDto> findByPageable(Pageable pageable) {
        Page<Category> entities = categoryEntityRepo.findLimit(pageable);
        return entities.map(new Function<Category, CategoryDto>() {
            @Override
            public CategoryDto apply(Category category) {
                return CategoryMapper.toDto(category);
            }
        });
    }

    @Override
    public List<SubCategoryDto> findSubCategoryByCategoryId(long id) {
        List<SubCategory> list = subCategoryRepo.findByCategoryId(id);
        return SubCategoryMapper.toDto(list);
    }

    @Override
    public void update(CategoryDto category) {
        Category categoryEntity = CategoryMapper.toEntity(category);
        categoryEntityRepo.save(categoryEntity);
    }

}

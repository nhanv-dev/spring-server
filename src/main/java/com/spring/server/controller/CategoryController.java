package com.spring.server.controller;

import com.spring.server.model.dto.CategoryDto;
import com.spring.server.model.dto.SubCategoryDto;
import com.spring.server.model.mapper.CategoryMapper;
import com.spring.server.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("")
    public ResponseEntity<?> getCategoryByLimit(
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer limit,
            @RequestParam(required = false) String type) {
        if (page == null) {
            if (type != null && type.equals("short")) return ResponseEntity.ok(categoryService.findAllWithoutSub());
            return ResponseEntity.ok(categoryService.findAll());
        }
        Pageable pageable = PageRequest.of(page - 1, limit);
        return ResponseEntity.ok(categoryService.findByPageable(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable(value = "id") Long id) {
        CategoryDto category = categoryService.findOneById(id);

        return ResponseEntity.ok(category);
    }

    @GetMapping("/slug/{slug}")
    public ResponseEntity<?> getCategoryById(@PathVariable String slug) {
        CategoryDto category = categoryService.findOneBySlug(slug);
        return ResponseEntity.ok(category);
    }

    @GetMapping("/{id}/sub-categories")
    public ResponseEntity<?> getSubCategoryByCategoryId(@PathVariable(value = "id") Long id) {
        List<SubCategoryDto> category = categoryService.findSubCategoryByCategoryId(id);
        return ResponseEntity.ok(category);
    }

    @PostMapping()
    public ResponseEntity<?> createCategory(@RequestBody CategoryDto categoryDto) {
        return ResponseEntity.ok(categoryDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable(value = "id") Long id, @RequestBody CategoryDto categoryDto) {
        return ResponseEntity.ok(categoryDto);
    }

    @PostMapping("/sub-categories")
    public ResponseEntity<?> createSubCategory(@RequestBody SubCategoryDto categoryDto) {
        return ResponseEntity.ok(categoryDto);
    }

    @PutMapping("/{id}/sub-categories")
    public ResponseEntity<?> updateSubCategory(@PathVariable(value = "id") Long id, @RequestBody SubCategoryDto categoryDto) {
        return ResponseEntity.ok(categoryDto);
    }

}

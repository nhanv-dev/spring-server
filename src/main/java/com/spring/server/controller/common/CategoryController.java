package com.spring.server.controller.common;

import com.spring.server.model.dto.CategoryDto;
import com.spring.server.model.dto.SubCategoryDto;
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
    public ResponseEntity<?> getCategoryByLimit(@RequestParam(required = false) Integer page) {
        if (page == null) return ResponseEntity.ok(categoryService.findAll());
        Pageable pageable = PageRequest.of(page, 60);
        return ResponseEntity.ok(categoryService.findLimit(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable(value = "id") Long id) {
        CategoryDto category = categoryService.findOneById(id);

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

package com.example.productcategoryservice.endpoint;

import com.example.productcategoryservice.dto.CategoryResponseDto;
import com.example.productcategoryservice.dto.CreateCategoryDto;
import com.example.productcategoryservice.mapper.CategoryMapper;
import com.example.productcategoryservice.model.Category;
import com.example.productcategoryservice.model.Product;
import com.example.productcategoryservice.repository.CategoryRepository;
import com.example.productcategoryservice.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CategoryEndpoint {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;


    @GetMapping("/categories")
    public List<CategoryResponseDto> getAllCategories() {
        return  categoryMapper.map(categoryService.showAllCategories());
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("id") int id) {
        Optional<Category> byId = categoryService.findById(id);
        if (byId.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(byId.get());
    }

    @PostMapping("/categories")
    public ResponseEntity<CategoryResponseDto> createCategory(@RequestBody CreateCategoryDto createCategoryDto) {
        categoryService.save(categoryMapper.map(createCategoryDto));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/categories")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category) {
        if (category.getId() == 0) {
            return ResponseEntity.badRequest().build();
        }
        categoryService.save(category);
        return ResponseEntity.ok(category);
    }

    @DeleteMapping("/categories/{id}")
    public ResponseEntity<?> deleteCategoryFromId(@PathVariable("id") int id) {
        categoryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}

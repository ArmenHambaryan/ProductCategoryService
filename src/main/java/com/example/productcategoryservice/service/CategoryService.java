package com.example.productcategoryservice.service;

import com.example.productcategoryservice.excepion.NotFoundException;
import com.example.productcategoryservice.model.Category;
import com.example.productcategoryservice.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;


    public List<Category> showAllCategories() {
        return categoryRepository.findAll();
    }

    public Category findById(int id) {
        Optional<Category> byId = categoryRepository.findById(id);
        if (byId.isEmpty()) {
            throw new NotFoundException("not found category by id");
        }
        return byId.get();
    }

    public void save(Category category) {
        if (category == null) {
            throw new RuntimeException("category cant be null");
        }
        categoryRepository.save(category);
    }

    public void deleteById(int id) {
        if (id == 0) {
            throw new NumberFormatException("id with 0 dont exist");
        }

        categoryRepository.deleteById(id);
    }
}

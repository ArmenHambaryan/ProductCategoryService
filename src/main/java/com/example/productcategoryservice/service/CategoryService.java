package com.example.productcategoryservice.service;

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

    public Optional<Category> findById(int id) {

        return categoryRepository.findById(id);
    }

    public void save(Category category) {

        categoryRepository.save(category);
    }

    public void deleteById(int id) {

        categoryRepository.deleteById(id);
    }
}

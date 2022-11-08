package com.example.productcategoryservice.service;

import com.example.productcategoryservice.excepion.NotFoundException;
import com.example.productcategoryservice.model.Category;
import com.example.productcategoryservice.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class CategoryServiceTest {

    @MockBean
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryService categoryService;


    @Test
    void findById() {
        Category category = Category.builder()
                .id(1)
                .name("Poxos")
                .build();
        when(categoryRepository.save(any())).thenReturn(category);
        assertThrows(NotFoundException.class, () -> {
            categoryService.findById(0);
        });
        verify(categoryRepository, times(0)).save(any());
    }

    @Test
    void save() {
        Category category = Category.builder()
                .id(1)
                .name("Poxos")
                .build();
        when(categoryRepository.save(any())).thenReturn(category);

        categoryService.save(Category.builder()
                .name("Poxos")
                .build());
        verify(categoryRepository, times(1)).save(any());
    }

    @Test
    void saveNull() {
        Category category = Category.builder()
                .id(1)
                .name("Poxos")
                .build();
        when(categoryRepository.save(any())).thenReturn(category);
        assertThrows(RuntimeException.class, () -> {
            categoryService.save(null);
        });

        verify(categoryRepository, times(0)).save(any());
    }

    @Test
    void deleteById() {
        Category category = Category.builder()
                .id(1)
                .name("Poxos")
                .build();
        when(categoryRepository.save(any())).thenReturn(category);
        assertThrows(NumberFormatException.class, () -> {
            categoryService.deleteById(0);
        });

        verify(categoryRepository, times(0)).save(any());

    }
}
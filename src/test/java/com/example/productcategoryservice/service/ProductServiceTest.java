package com.example.productcategoryservice.service;

import com.example.productcategoryservice.excepion.NotFoundException;
import com.example.productcategoryservice.model.Category;
import com.example.productcategoryservice.model.Product;
import com.example.productcategoryservice.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class ProductServiceTest {

    @MockBean
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @Test
    void findById() {
        Product product = Product.builder()
                .id(1)
                .count(23)
                .price(23.3)
                .title("saaw")
                .build();
        when(productRepository.save(any())).thenReturn(product);
        assertThrows(NotFoundException.class, () -> {
            productService.findById(0);
        });
        verify(productRepository, times(0)).save(any());
    }

    @Test
    void save() {
        Product product = Product.builder()
                .id(1)
                .count(23)
                .price(23.3)
                .title("saaw")
                .build();
        when(productRepository.save(any())).thenReturn(product);

        productService.save(Product.builder()
                .count(23)
                .price(23.3)
                .title("saaw")
                .build());
        verify(productRepository, times(1)).save(any());
    }

    @Test
    void saveNull() {
        Product product = Product.builder()
                .id(1)
                .count(23)
                .price(23.3)
                .title("saaw")
                .build();
        when(productRepository.save(any())).thenReturn(product);
        assertThrows(RuntimeException.class, () -> {
            productService.save(null);
        });

        verify(productRepository, times(0)).save(any());
    }

    @Test
    void deleteById() {
        Product product = Product.builder()
                .id(1)
                .count(23)
                .price(23.3)
                .title("saaw")
                .build();
        when(productRepository.save(any())).thenReturn(product);
        assertThrows(NumberFormatException.class, () -> {
            productService.deleteById(0);
        });

        verify(productRepository, times(0)).save(any());

    }
}
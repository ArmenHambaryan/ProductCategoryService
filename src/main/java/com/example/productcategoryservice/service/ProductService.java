package com.example.productcategoryservice.service;


import com.example.productcategoryservice.model.Product;
import com.example.productcategoryservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;


    public List<Product> showAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(int id) {
        return productRepository.findById(id);
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public void deleteById(int id) {
        productRepository.deleteById(id);
    }

    public List<Product> findAllByCategoryId(int id) {
        return productRepository.findAllByCategoryId(id);
    }
}

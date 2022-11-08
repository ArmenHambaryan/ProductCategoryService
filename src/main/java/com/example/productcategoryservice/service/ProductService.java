package com.example.productcategoryservice.service;


import com.example.productcategoryservice.excepion.NotFoundException;
import com.example.productcategoryservice.model.Category;
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

    public Product findById(int id) {
        Optional<Product> byId = productRepository.findById(id);
        if (byId.isEmpty()) {
            throw new NotFoundException("not found product by id");
        }
        return byId.get();
    }

    public void save(Product product) {
        if (product == null) {
            throw new RuntimeException("product cant be null");
        }
        productRepository.save(product);
    }

    public void deleteById(int id) {
        if (id == 0) {
            throw new NumberFormatException("id with 0 dont exist");}

            productRepository.deleteById(id);
        }
    public List<Product> findAllByCategoryId(int id) {

        return productRepository.findAllByCategoryId(id);
    }
}

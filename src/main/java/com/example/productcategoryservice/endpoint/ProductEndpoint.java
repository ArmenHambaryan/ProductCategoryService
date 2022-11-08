package com.example.productcategoryservice.endpoint;

import com.example.productcategoryservice.dto.CreateProductDto;
import com.example.productcategoryservice.dto.ProductResponseDto;
import com.example.productcategoryservice.mapper.ProductMapper;
import com.example.productcategoryservice.model.Product;
import com.example.productcategoryservice.repository.ProductRepository;
import com.example.productcategoryservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ProductEndpoint {

    private final ProductService productService;
    private final ProductMapper productMapper;

    @GetMapping("/products")
    public List<ProductResponseDto> getAllProducts() {

        return productMapper.map(productService.showAllProducts());
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<?> getProductById(@PathVariable("id") int id) {
        productService.findById(id);
        return ResponseEntity.ok(productMapper.map(productService.findById(id)));
    }

    @PostMapping("/products")
    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody CreateProductDto createProductDto) {
        productService.save(productMapper.map(createProductDto));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/products")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        if (product.getId() == 0) {
            return ResponseEntity.badRequest().build();
        }
        productService.save(product);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<?> deleteProductFromId(@PathVariable("id") int id) {
        productService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/products/{id}")
    public List<Product> findAllByCategoryId(@PathVariable("id") int id){
       return productService.findAllByCategoryId(id);
    }
}

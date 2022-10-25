package com.example.productcategoryservice.dto;

import com.example.productcategoryservice.model.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponseDto {
    private int id;
    private String title;
    private int count;
    private double price;
    private Category category;
}



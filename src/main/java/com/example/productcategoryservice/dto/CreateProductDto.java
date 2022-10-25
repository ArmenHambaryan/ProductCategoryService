package com.example.productcategoryservice.dto;

import com.example.productcategoryservice.model.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductDto {

    private String title;
    private int count;
    private double price;
    private Category category;
}

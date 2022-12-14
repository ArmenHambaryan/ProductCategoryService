package com.example.productcategoryservice.mapper;

import com.example.productcategoryservice.dto.CategoryResponseDto;
import com.example.productcategoryservice.dto.CreateCategoryDto;
import com.example.productcategoryservice.dto.CreateProductDto;
import com.example.productcategoryservice.dto.ProductResponseDto;
import com.example.productcategoryservice.model.Category;
import com.example.productcategoryservice.model.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category map(CreateCategoryDto createCategoryDto);

    CategoryResponseDto map(Category category);

    List<CategoryResponseDto> map(List<Category> categoryList);
}

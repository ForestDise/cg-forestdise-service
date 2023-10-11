package com.forestdise.service;

import com.forestdise.dto.ProductDto;

import java.util.List;

public interface ProductService {
    ProductDto getProductById(Long id);
    List<ProductDto> getAllProductDtos();
}

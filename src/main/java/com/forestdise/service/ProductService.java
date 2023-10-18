package com.forestdise.service;

import com.forestdise.dto.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    ProductDto getProductById(Long id);
    List<ProductDto> getAllProductDtos();
}

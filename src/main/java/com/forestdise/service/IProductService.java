package com.forestdise.service;

import com.forestdise.dto.ProductDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    public ProductDto getProductById(Long id);
    public List<ProductDto> getAllProductDtos();
}

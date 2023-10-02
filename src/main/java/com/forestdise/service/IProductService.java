package com.forestdise.service;

import com.forestdise.dto.ProductDto;

public interface IProductService {
    public ProductDto getProductById(Long id);
}

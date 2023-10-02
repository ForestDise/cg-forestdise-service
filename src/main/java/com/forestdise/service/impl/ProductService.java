package com.forestdise.service.impl;

import com.forestdise.converter.ProductConverter;
import com.forestdise.dto.ProductDto;
import com.forestdise.entity.Product;
import com.forestdise.repository.ProductRepository;
import com.forestdise.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductConverter productConverter;
    @Autowired
    private ProductRepository productRepository;
    public ProductDto getProductById(Long id) {
        Product product = productRepository.findById(id).orElse(null) ;
        return productConverter.entityToDTO(product);
    }

}
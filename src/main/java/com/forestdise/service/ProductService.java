package com.forestdise.service;

import com.forestdise.converter.ProductConverter;
import com.forestdise.dto.ProductDto;
import com.forestdise.dto.VariantDto;
import com.forestdise.entity.Product;
import com.forestdise.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductConverter productConverter;
    @Autowired
    private ProductRepository productRepository;
    public ProductDto getProductById(Long id) {
        Product product = productRepository.findById(id).orElse(null) ;
        return productConverter.entityToDTO(product);
    }

}

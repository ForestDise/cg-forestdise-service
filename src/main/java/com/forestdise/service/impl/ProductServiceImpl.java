package com.forestdise.service.impl;

import com.forestdise.converter.impl.ProductConverterImpl;
import com.forestdise.dto.ProductDto;
import com.forestdise.entity.Product;
import com.forestdise.repository.ProductRepository;
import com.forestdise.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductConverterImpl productConverterImpl;
    @Autowired
    private ProductRepository productRepository;
    public ProductDto getProductById(Long id) {
        Product product = productRepository.findById(id).orElse(null) ;
        return productConverterImpl.entityToDTO(product);
    }

    @Override
    public List<ProductDto> getAllProductDtos() {
        return productConverterImpl.entitiesToDTOs(productRepository.findAll());
    }



}
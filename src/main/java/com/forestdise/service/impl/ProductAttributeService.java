package com.forestdise.service.impl;

import com.forestdise.converter.ProductAttributeConverter;
import com.forestdise.dto.ProductAttributeDto;
import com.forestdise.entity.ProductAttribute;
import com.forestdise.repository.ProductAttributeRepository;
import com.forestdise.service.IProductAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductAttributeService implements IProductAttributeService {
    @Autowired
    private ProductAttributeRepository productAttributeRepository;
    @Autowired
    private ProductAttributeConverter productAttributeConverter;

    @Override
    public List<ProductAttributeDto> getProductAttributeByProductId(Long product_id) {
        List<ProductAttribute> productAttributeList = productAttributeRepository.findByProductId(product_id);
        return productAttributeConverter.entitiesToDTOs(productAttributeList);
    }
//    public List<ProductAttributeDto> getProductAttributeByProductId(Long product_id) {
//        List<ProductAttribute> productAttributeList = productAttributeRepository.findByProductId(product_id);
//        return productAttributeConverter.entitiesToDTOs(productAttributeList);
//    }
}

package com.forestdise.service.impl;

import com.forestdise.converter.impl.ProductAttributeConverterImpl;
import com.forestdise.dto.ProductAttributeDTO;
import com.forestdise.entity.ProductAttribute;
import com.forestdise.repository.ProductAttributeRepository;
import com.forestdise.service.ProductAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductAttributeServiceImpl implements ProductAttributeService {
    @Autowired
    private ProductAttributeRepository productAttributeRepository;
    @Autowired
    private ProductAttributeConverterImpl productAttributeConverterImpl;

    @Override
    public List<ProductAttributeDTO> getProductAttributeByProductId(Long product_id) {
        List<ProductAttribute> productAttributeList = productAttributeRepository.findByProductId(product_id);
        return productAttributeConverterImpl.entitiesToDTOs(productAttributeList);
    }

}

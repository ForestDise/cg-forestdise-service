package com.forestdise.service.impl;

import com.forestdise.converter.impl.ProductAttributeConverterImpl;
import com.forestdise.dto.ProductAttributeDto;
import com.forestdise.entity.Product;
import com.forestdise.entity.ProductAttribute;
import com.forestdise.repository.ProductAttributeRepository;
import com.forestdise.repository.ProductRepository;
import com.forestdise.service.IProductAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ProductAttributeServiceImpl implements IProductAttributeService {
    @Autowired
    private ProductAttributeRepository productAttributeRepository;
    @Autowired
    private ProductAttributeConverterImpl productAttributeConverterImpl;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductAttributeDto> getProductAttributeByProductId(Long product_id) {
        List<ProductAttribute> productAttributeList = productAttributeRepository.findByProductId(product_id);
        return productAttributeConverterImpl.entitiesToDTOs(productAttributeList);
    }

    @Override
    public List<ProductAttribute> createProductAttribute(List<ProductAttributeDto> productAttributeDtoList, Long product_Id) {
        Product product = productRepository.findById(product_Id)
                .orElseThrow(()-> new EntityNotFoundException("Product not found"));
        if(product != null){
            for(ProductAttributeDto element : productAttributeDtoList){
                ProductAttribute productAttribute = new ProductAttribute();
                productAttribute.setName(element.getName());
                productAttribute.setValue(element.getValue());
                productAttribute.setProduct(product);
                productAttributeRepository.save(productAttribute);
            }
        }
        List<ProductAttribute> productAttributeList = product.getProductAttributes();
        return productAttributeList;
    }

}

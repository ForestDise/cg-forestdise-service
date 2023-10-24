package com.forestdise.service;

import com.forestdise.dto.ProductAttributeDto;
import com.forestdise.entity.ProductAttribute;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IProductAttributeService {
     List<ProductAttributeDto> getProductAttributeByProductId(Long product_id);
     List<ProductAttribute> createProductAttribute(List<ProductAttributeDto> productAttributeDtoList, Long product_Id);
}

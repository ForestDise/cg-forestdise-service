package com.forestdise.service;

import com.forestdise.dto.ProductAttributeDto;

import java.util.List;

public interface ProductAttributeService {
    public List<ProductAttributeDto> getProductAttributeByProductId(Long product_id);
}

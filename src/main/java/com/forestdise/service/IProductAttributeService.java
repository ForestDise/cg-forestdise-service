package com.forestdise.service;

import com.forestdise.dto.ProductAttributeDto;

import java.util.List;

public interface IProductAttributeService {
    public List<ProductAttributeDto> getProductAttributeByProductId(Long product_id);
}
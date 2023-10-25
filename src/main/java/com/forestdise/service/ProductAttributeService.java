package com.forestdise.service;

import com.forestdise.dto.ProductAttributeDTO;

import java.util.List;


public interface ProductAttributeService {
    public List<ProductAttributeDTO> getProductAttributeByProductId(Long product_id);
}

package com.forestdise.service;

import com.forestdise.dto.ProductAttributeDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductAttributeService {
    public List<ProductAttributeDTO> getProductAttributeByProductId(Long product_id);
}

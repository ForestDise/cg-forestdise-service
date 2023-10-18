package com.forestdise.service;

import com.forestdise.dto.ProductAttributeDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductAttributeService {
    public List<ProductAttributeDto> getProductAttributeByProductId(Long product_id);
}

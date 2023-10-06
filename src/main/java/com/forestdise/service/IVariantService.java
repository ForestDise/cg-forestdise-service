package com.forestdise.service;

import com.forestdise.dto.ProductDto;
import com.forestdise.dto.VariantDto;

import java.util.List;

public interface IVariantService {
     VariantDto getVariantById(Long id);
     List<VariantDto> getVariantByProductId(Long product_id);

}

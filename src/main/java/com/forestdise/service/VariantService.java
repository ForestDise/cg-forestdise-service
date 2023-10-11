package com.forestdise.service;

import com.forestdise.dto.VariantDto;
import com.forestdise.entity.Variant;

import java.util.List;

public interface VariantService {
     VariantDto getVariantById(Long id);
     List<VariantDto> getVariantByProductId(Long product_id);
     Variant findById(Long id);
}

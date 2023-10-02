package com.forestdise.service;

import com.forestdise.dto.VariantDto;

import java.util.List;

public interface IVariantService {
    public VariantDto getVariantById(Long id);
    public List<VariantDto> getVariantByProductId(Long product_id);
}
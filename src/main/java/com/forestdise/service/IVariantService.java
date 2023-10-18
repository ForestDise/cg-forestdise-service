package com.forestdise.service;

import com.forestdise.dto.VariantDto;
import com.forestdise.entity.Variant;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IVariantService {
    public VariantDto getVariantById(Long id);
    public List<VariantDto> getVariantByProductId(Long product_id);
    public Variant findById(Long id);

    public VariantDto getLowestPriceVariantByProductId(Long product_id);
}

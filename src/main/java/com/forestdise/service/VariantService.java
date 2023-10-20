package com.forestdise.service;

import com.forestdise.dto.VariantDTO;
import com.forestdise.entity.Variant;

import java.util.List;


public interface VariantService {
    public VariantDTO getVariantById(Long id);
    public List<VariantDTO> getVariantByProductId(Long product_id);
    public Variant findById(Long id);

    public VariantDTO getLowestPriceVariantByProductId(Long product_id);
    public VariantDTO getVariantByProductPriceMin(Long product_id);

}

package com.forestdise.service;

import com.forestdise.dto.ProductDto;
import com.forestdise.dto.VariantDto;
import com.forestdise.entity.Variant;

import java.util.List;


public interface IVariantService {
    public VariantDto getVariantById(Long id);
    public List<VariantDto> getVariantByProductId(Long product_id);
    public Variant findById(Long id);

    public VariantDto getLowestPriceVariantByProductId(Long product_id);
    public VariantDto getVariantByProductPriceMin(Long product_id);
    public Variant createVariant(VariantDto variantDto,Long product_id);
    public Variant updateVariant(VariantDto variantDto);
    public void deleteVariant(Long variantId);
}

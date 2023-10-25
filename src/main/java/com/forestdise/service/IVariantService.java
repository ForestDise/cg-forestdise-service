package com.forestdise.service;

import com.forestdise.dto.VariantDto;
import com.forestdise.entity.Variant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IVariantService {
     VariantDto getVariantById(Long id);
     List<VariantDto> getVariantByProductId(Long product_id);
     Variant findById(Long id);

     VariantDto getLowestPriceVariantByProductId(Long product_id);
     VariantDto getVariantByProductPriceMin(Long product_id);
     Variant createVariant(VariantDto variantDto,Long product_id);
     Variant updateVariant(VariantDto variantDto);
     void deleteVariant(Long variantId);
     Page<VariantDto> getVariantsByContaining(String text, Pageable pageable);
     Page<VariantDto> getVariantsByNameContainingAndPriceBetween(String text,double minPrice, double maxPrice, Pageable pageable );
     Page<VariantDto> getVariantsBySearchTextAndRating(String text, long star,Pageable pageable);
}

package com.forestdise.payload.response;

import com.forestdise.dto.ProductAttributeDto;
import com.forestdise.dto.ProductDto;
import com.forestdise.dto.VariantDto;
import lombok.Data;

import java.util.List;
@Data
public class ProductDetailResponse {
    private ProductDto productDTO;
    private List<VariantDto> variantDtos;
    private List<ProductAttributeDto> productAttributeDtos;
}

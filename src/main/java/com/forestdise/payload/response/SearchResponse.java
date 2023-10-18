package com.forestdise.payload.response;

import com.forestdise.dto.ProductDto;
import com.forestdise.dto.VariantDto;
import com.forestdise.entity.Variant;
import lombok.Data;

import java.util.List;

@Data
public class SearchResponse {
    private List<ProductDto> productDtos;
    private List<VariantDto> variantDtos;

}

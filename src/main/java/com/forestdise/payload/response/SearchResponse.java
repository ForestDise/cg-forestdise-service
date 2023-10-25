package com.forestdise.payload.response;

import com.forestdise.dto.ProductDTO;
import com.forestdise.dto.VariantDTO;

import lombok.Data;

import java.util.List;

@Data
public class SearchResponse {

    private List<ProductDTO> productDTOS;
    private List<VariantDTO> variantDTOS;
}

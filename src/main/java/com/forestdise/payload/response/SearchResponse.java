package com.forestdise.payload.response;

import com.forestdise.dto.ProductDto;
import com.forestdise.dto.VariantDto;
import lombok.Data;
import org.springframework.data.domain.Page;
@Data
public class SearchResponse {
//    private Page<ProductDto> productDtos;
    private Page<VariantDto> variantDtoPage;
}

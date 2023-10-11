package com.forestdise.payload.response;

import com.forestdise.dto.ProductDto;
import lombok.Data;

import java.util.List;

@Data
public class SearchResponse {
    private List<ProductDto> productDtos;
}

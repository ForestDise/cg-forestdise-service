package com.forestdise.payload.response;

import com.forestdise.dto.*;
import lombok.Data;

import java.util.List;
@Data
public class ProductDetailResponse {
    private ProductDto productDTO;
    private int ratings;
    private double star;
    private StoreDto storeDto;
    private List<OptionTableDto> optionTableDto;
    private List<VariantDto> variantDtoList;
    private List<ProductAttributeDto> productAttributeDtoList;
    private VariantDto variantDto;
    private List<ReviewDto> reviewDtoList;


}

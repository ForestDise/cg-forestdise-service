package com.forestdise.payload.response;

import com.forestdise.dto.*;
import lombok.Data;

import java.util.List;
@Data
public class ProductDetailResponse {
    private ProductDTO productDTO;
    private int ratings;
    private double star;
    private StoreDTO storeDto;
    private List<OptionTableDTO> optionTableDto;
    private List<VariantDTO> variantDtoList;
    private List<ProductAttributeDTO> productAttributeDtoList;
    private VariantDTO variantDto;
    private List<ReviewDTO> reviewDtoList;


}

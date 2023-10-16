package com.forestdise.payload.response;

import com.forestdise.dto.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private ProductDto productDto;
    private List<ProductAttributeDto> productAttributeDtoList;
    private StoreDto storeDto;
    private List<OptionTableDto> optionTableDto;
    private List<VariantDto> variantDtoList;
    private VariantDto variantDto;
    // lấy ra 1 variant có price thấp rồi setcho nó variant hiện tại


}

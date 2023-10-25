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
    private ProductDTO productDto;
    private List<ProductAttributeDTO> productAttributeDtoList;
    private StoreDTO storeDto;
    private List<OptionTableDTO> optionTableDto;
    private List<VariantDTO> variantDtoList;
    private VariantDTO variantDto;
    // lấy ra 1 variant có price thấp rồi setcho nó variant hiện tại


}

package com.forestdise.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import reactor.util.annotation.Nullable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SaveForLaterDto {
    private Long id;
    private int quantity;
    private CartDto cartDto;
    private VariantDto variantDto;
}

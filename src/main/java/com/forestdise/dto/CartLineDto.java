package com.forestdise.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Null;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartLineDto {
    @Null
    private Long id;
    private int quantity;
    private CartDto cartDto;
    private VariantDto variantDto;
}

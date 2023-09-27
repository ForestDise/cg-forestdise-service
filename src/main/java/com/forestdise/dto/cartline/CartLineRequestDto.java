package com.forestdise.dto.cartline;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartLineRequestDto {
    private Long id;

    @NotNull
    @Min(0)
    private int quantity;
    private Long cartId;
    private Long variantId;
}

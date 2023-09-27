package com.forestdise.dto.cartline;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartLineResponseDto {
    private Long id;
    private int quantity;
    private Long cartId;
    private Long variantId;
}

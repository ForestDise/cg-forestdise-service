package com.forestdise.payload.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartLineRequest {
    private Long id;
    private int quantity;
    private Long cartId;
    private Long variantId;
}

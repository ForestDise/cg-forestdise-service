package com.forestdise.dto.cart;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.UniqueConstraint;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartRequestDto {
    private Long id;
    private Long userId;
}

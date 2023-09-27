package com.forestdise.converter.impl;

import com.forestdise.converter.Converter;
import com.forestdise.dto.cart.CartRequestDto;
import com.forestdise.dto.cart.CartResponseDto;
import com.forestdise.entity.Cart;
import org.springframework.stereotype.Component;

@Component
public class CartConverter implements Converter<CartRequestDto, Cart, CartResponseDto> {
    @Override
    public Cart convertFromRequestDtoToEntity(CartRequestDto cartRequestDto) {
        return null;
    }

    @Override
    public Cart convertFromResponseDtoToEntity(CartResponseDto cartResponseDto) {
        return null;
    }

    @Override
    public CartRequestDto convertFromEntityToRequestDto(Cart cart) {
        return null;
    }

    @Override
    public CartResponseDto convertFromEntityToResponseDto(Cart cart) {
        return null;
    }
}

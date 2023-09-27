package com.forestdise.converter.impl;

import com.forestdise.converter.Converter;
import com.forestdise.dto.cartline.CartLineRequestDto;
import com.forestdise.dto.cartline.CartLineResponseDto;
import com.forestdise.entity.CartLine;
import org.springframework.stereotype.Component;

@Component
public class CartLineConverter implements Converter<CartLineRequestDto, CartLine, CartLineResponseDto> {
    @Override
    public CartLine convertFromRequestDtoToEntity(CartLineRequestDto cartLineRequestDto) {
        return null;
    }

    @Override
    public CartLine convertFromResponseDtoToEntity(CartLineResponseDto cartLineResponseDto) {
        return null;
    }

    @Override
    public CartLineRequestDto convertFromEntityToRequestDto(CartLine cartLine) {
        return null;
    }

    @Override
    public CartLineResponseDto convertFromEntityToResponseDto(CartLine cartLine) {
        return null;
    }
}

package com.forestdise.converter.impl;

import com.forestdise.converter.CartLineConverter;
import com.forestdise.dto.CartLineDto;
import com.forestdise.entity.CartLine;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CartLineConverterImpl implements CartLineConverter {
    @Override
    public CartLine convertDtoToEntity(CartLineDto cartLineDto) {
        CartLine cartLine = new CartLine();
        BeanUtils.copyProperties(cartLineDto, cartLine);
        return cartLine;
    }

    @Override
    public CartLineDto convertEntityToDto(CartLine cartLine) {
        CartLineDto cartLineDto = new CartLineDto();
        BeanUtils.copyProperties(cartLine, cartLineDto);
        return cartLineDto;
    }

    @Override
    public List<CartLineDto> convertEntitiesToDtos(List<CartLine> cartLines) {
        return cartLines.stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CartLine> convertDtoToEntities(List<CartLineDto> cartLineDtos) {
        return null;
    }
}

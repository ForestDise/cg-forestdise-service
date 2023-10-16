package com.forestdise.converter;

import com.forestdise.dto.CartLineDto;
import com.forestdise.entity.CartLine;

import java.util.List;

public interface CartLineConverter {
    CartLine convertDtoToEntity(CartLineDto cartLineDto);
    CartLineDto convertEntityToDto(CartLine cartLine);
    List<CartLineDto> convertEntitiesToDtos(List<CartLine> cartLines);
    List<CartLine> convertDtoToEntities(List<CartLineDto> cartLineDtos);
}

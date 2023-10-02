package com.forestdise.converter;

import com.forestdise.dto.CartDto;
import com.forestdise.dto.CartLineDto;
import com.forestdise.entity.Cart;
import com.forestdise.entity.CartLine;

public interface CartLineConverter {
    CartLine convertDtoToEntity(CartLineDto cartLineDto);
    CartLineDto convertEntityToDto(CartLine cartLine);
}

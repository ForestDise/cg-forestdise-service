package com.forestdise.converter;

import com.forestdise.dto.CartDto;
import com.forestdise.entity.Cart;

public interface CartConverter {
    Cart convertDtoToEntity(CartDto cartDto);
    CartDto convertEntityToDto(Cart cart);
}

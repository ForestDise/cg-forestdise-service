package com.forestdise.converter.impl;

import com.forestdise.converter.CartConverter;
import com.forestdise.dto.CartDto;
import com.forestdise.entity.Cart;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CartConverterImpl implements CartConverter {
    @Override
    public Cart convertDtoToEntity(CartDto cartDto) {
        Cart cart = new Cart();
        BeanUtils.copyProperties(cartDto, cart);
        return cart;
    }

    @Override
    public CartDto convertEntityToDto(Cart cart) {
        CartDto cartDto = new CartDto();
        BeanUtils.copyProperties(cart, cartDto);
        return cartDto;
    }


}

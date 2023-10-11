package com.forestdise.converter.impl;

import com.forestdise.converter.CartConverter;
import com.forestdise.converter.CartLineConverter;
import com.forestdise.converter.VariantConverter;
import com.forestdise.dto.CartDto;
import com.forestdise.dto.CartLineDto;
import com.forestdise.dto.VariantDto;
import com.forestdise.entity.Cart;
import com.forestdise.entity.CartLine;
import com.forestdise.entity.Variant;
import com.forestdise.service.CartService;
import com.forestdise.service.VariantService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CartLineConverterImpl implements CartLineConverter {
    @Autowired
    private CartService cartService;

    @Autowired
    private VariantService variantService;

    @Autowired
    private CartConverter cartConverter;

    @Autowired
    private VariantConverter variantConverter;

    @Override
    public CartLine convertDtoToEntity(CartLineDto cartLineDto) {
        CartLine cartLine = new CartLine();
        BeanUtils.copyProperties(cartLineDto, cartLine);
        Cart cart = cartService.findById(cartLineDto.getCartDto().getId());
        Variant variant = variantService.findById(cartLineDto.getVariantDto().getId());
        cartLine.setCart(cart);
        cartLine.setVariant(variant);
        return cartLine;
    }

    @Override
    public CartLineDto convertEntityToDto(CartLine cartLine) {
        CartLineDto cartLineDto = new CartLineDto();
        BeanUtils.copyProperties(cartLine, cartLineDto);
        CartDto cartDto = cartConverter.convertEntityToDto(cartLine.getCart());
        VariantDto variantDto = variantConverter.entityToDTO(cartLine.getVariant());
        cartLineDto.setCartDto(cartDto);
        cartLineDto.setVariantDto(variantDto);
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

package com.forestdise.converter.impl;

import com.forestdise.converter.CartConverter;
import com.forestdise.converter.SaveForLaterConverter;
import com.forestdise.converter.VariantConverter;
import com.forestdise.dto.CartDto;
import com.forestdise.dto.SaveForLaterDto;
import com.forestdise.dto.VariantDto;
import com.forestdise.entity.Cart;
import com.forestdise.entity.SaveForLater;
import com.forestdise.entity.Variant;
import com.forestdise.service.CartService;
import com.forestdise.service.VariantService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SaveForLaterConverterImpl implements SaveForLaterConverter {
    @Autowired
    private CartService cartService;

    @Autowired
    private VariantService variantService;

    @Autowired
    private CartConverter cartConverter;

    @Autowired
    private VariantConverter variantConverter;

    @Override
    public SaveForLater convertDtoToEntity(SaveForLaterDto saveForLaterDto) {
        SaveForLater saveForLater = new SaveForLater();
        BeanUtils.copyProperties(saveForLaterDto, saveForLater);
        Cart cart = cartService.findById(saveForLaterDto.getCartDto().getId());
        Variant variant = variantService.findById(saveForLaterDto.getVariantDto().getId());
        saveForLater.setCart(cart);
        saveForLater.setVariant(variant);
        return saveForLater;
    }

    @Override
    public SaveForLaterDto convertEntityToDto(SaveForLater saveForLater) {
        SaveForLaterDto saveForLaterDto = new SaveForLaterDto();
        BeanUtils.copyProperties(saveForLater, saveForLaterDto);
        CartDto cartDto = cartConverter.convertEntityToDto(saveForLater.getCart());
        VariantDto variantDto = variantConverter.entityToDTO(saveForLater.getVariant());
        saveForLaterDto.setCartDto(cartDto);
        saveForLaterDto.setVariantDto(variantDto);
        return saveForLaterDto;
    }

    @Override
    public List<SaveForLaterDto> convertEntitiesToDtos(List<SaveForLater> saveForLaters) {
        return saveForLaters.stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<SaveForLater> convertDtoToEntities(List<SaveForLaterDto> cartLineDtos) {
        return null;
    }
}

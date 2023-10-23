package com.forestdise.converter.impl;

import com.forestdise.converter.CartConverter;
import com.forestdise.converter.SaveForLaterConverter;
import com.forestdise.converter.IVariantConverter;
import com.forestdise.dto.CartDto;
import com.forestdise.dto.SaveForLaterDto;
import com.forestdise.dto.VariantDto;
import com.forestdise.entity.Cart;
import com.forestdise.entity.SaveForLater;
import com.forestdise.entity.Variant;
import com.forestdise.service.CartService;
import com.forestdise.service.IVariantService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SaveForLaterConverterImpl implements SaveForLaterConverter {
    @Autowired
    private CartService cartService;

    @Autowired
    private IVariantService variantService;

    @Autowired
    private CartConverter cartConverter;

    @Autowired
    private IVariantConverter variantConverter;



    @Override
    public SaveForLaterDto convertEntityToDto(SaveForLater saveForLater) {
        SaveForLaterDto saveForLaterDto = new SaveForLaterDto();
        Long id = saveForLater.getId();
        int quantity = saveForLater.getQuanity();
        CartDto cartDto = cartConverter.convertEntityToDto(saveForLater.getCart());
        VariantDto variantDto = variantConverter.entityToDTO(saveForLater.getVariant());
        saveForLaterDto.setId(id);
        saveForLaterDto.setQuantity(quantity);
        saveForLaterDto.setCartDto(cartDto);
        saveForLaterDto.setVariantDto(variantDto);
        return saveForLaterDto;
    }

    @Override
    public List<SaveForLaterDto> convertEntitiesToDtos(List<SaveForLater> saveForLaters) {
//        return saveForLaters.stream()
//                .map(this::convertEntityToDto)
//                .collect(Collectors.toList());
        List<SaveForLaterDto> saveForLaterDtoList = new ArrayList<>();
        for (SaveForLater saveForLater: saveForLaters) {
            SaveForLaterDto saveForLaterDto = convertEntityToDto(saveForLater);
            saveForLaterDtoList.add(saveForLaterDto);
        }
        return saveForLaterDtoList;
    }

    @Override
    public List<SaveForLater> convertDtoToEntities(List<SaveForLaterDto> cartLineDtos) {
        return null;
    }

    @Override
    public SaveForLater convertDtoToEntity(SaveForLaterDto saveForLaterDto) {
        return null;
    }
}

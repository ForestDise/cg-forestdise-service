package com.forestdise.converter.impl;

import com.forestdise.converter.ISellerConverter;
import com.forestdise.dto.SellerDto;
import com.forestdise.entity.Seller;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SellerConverterImpl implements ISellerConverter {
    @Override
    public List<SellerDto> entitiesToDTOs(List<Seller> element) {
        return element.stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SellerDto entityToDTO(Seller element) {
        SellerDto result = new SellerDto();
        BeanUtils.copyProperties(element, result);
        return result;
    }

    @Override
    public Seller dtoToEntity(SellerDto element) {
        Seller result = new Seller();
        BeanUtils.copyProperties(element, result);
        return result;
    }
}

package com.forestdise.converter.impl;

import com.forestdise.converter.IStoreConverter;
import com.forestdise.dto.StoreDto;
import com.forestdise.entity.Store;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StoreConverterImpl implements IStoreConverter {
    @Override
    public List<StoreDto> entitiesToDTOs(List<Store> element) {
        return element.stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public StoreDto entityToDTO(Store element) {
        StoreDto result = new StoreDto();
        BeanUtils.copyProperties(element, result);
        return result;
    }

    @Override
    public Store dtoToEntity(StoreDto element) {
        Store result = new Store();
        BeanUtils.copyProperties(element, result);
        return result;
    }
}

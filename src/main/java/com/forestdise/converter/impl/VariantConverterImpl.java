package com.forestdise.converter.impl;

import com.forestdise.converter.IVariantConverter;
import com.forestdise.dto.VariantDto;
import com.forestdise.entity.Variant;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class VariantConverterImpl implements IVariantConverter {
    @Override
    public List<VariantDto> entitiesToDTOs(List<Variant> element) {
        return element.stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }
    @Override

    public VariantDto entityToDTO(Variant element) {
        if (element == null) {
            return null;
        }
        VariantDto result = new VariantDto();
        BeanUtils.copyProperties(element, result);
        return result;
    }
    @Override

    public Variant dtoToEntity(VariantDto element) {
        if (element == null) {
            return null;
        }
        Variant result = new Variant();
        BeanUtils.copyProperties(element, result);
        return result;
    }
}

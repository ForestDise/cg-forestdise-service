package com.forestdise.converter.impl;

import com.forestdise.converter.IOptionValueConverter;
import com.forestdise.dto.OptionValueDto;
import com.forestdise.entity.OptionValue;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class OptionValueConverterImpl implements IOptionValueConverter {
    @Override
    public List<OptionValueDto> entitiesToDTOs(List<OptionValue> element) {
        return element.stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }
    @Override
    public OptionValueDto entityToDTO(OptionValue element) {
        OptionValueDto result = new OptionValueDto();
        BeanUtils.copyProperties(element, result);
        return result;
    }
    @Override
    public OptionValue dtoToEntity(OptionValueDto element) {
        OptionValue result = new OptionValue();
        BeanUtils.copyProperties(element, result);
        return result;
    }

    @Override
    public List<OptionValue> dtosToEntities(List<OptionValueDto> element) {
        return element.stream()
                .map(this::dtoToEntity)
                .collect(Collectors.toList());
    }
}

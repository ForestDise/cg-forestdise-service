package com.forestdise.converter.impl;

import com.forestdise.converter.IOptionTableConverter;
import com.forestdise.dto.OptionTableDto;
import com.forestdise.entity.OptionTable;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OptionTableConverterImpl implements IOptionTableConverter {
    @Override
    public List<OptionTableDto> entitiesToDTOs(List<OptionTable> element) {
        return element.stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }
    @Override
    public OptionTableDto entityToDTO(OptionTable element) {
        OptionTableDto result = new OptionTableDto();
        BeanUtils.copyProperties(element, result);
        return result;
    }
    @Override
    public OptionTable dtoToEntity(OptionTableDto element) {
        OptionTable result = new OptionTable();
        BeanUtils.copyProperties(element, result);
        return result;
    }
}

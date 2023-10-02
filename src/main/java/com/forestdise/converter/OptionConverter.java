package com.forestdise.converter;

import com.forestdise.dto.OptionDto;
import com.forestdise.entity.OptionTable;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OptionConverter {
    public List<OptionDto> entitiesToDTOs(List<OptionTable> element) {
        return element.stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }

    public OptionDto entityToDTO(OptionTable element) {
        OptionDto result = new OptionDto();
        BeanUtils.copyProperties(element, result);
        return result;
    }

    public OptionTable dtoToEntity(OptionDto element) {
        OptionTable result = new OptionTable();
        BeanUtils.copyProperties(element, result);
        return result;
    }
}

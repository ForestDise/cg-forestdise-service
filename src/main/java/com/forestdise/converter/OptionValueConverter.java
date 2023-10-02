package com.forestdise.converter;

import com.forestdise.dto.OptionValueDto;
import com.forestdise.entity.OptionValue;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class OptionValueConverter {
    public List<OptionValueDto> entitiesToDTOs(List<OptionValue> element) {
        return element.stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }

    public OptionValueDto entityToDTO(OptionValue element) {
        OptionValueDto result = new OptionValueDto();
        BeanUtils.copyProperties(element, result);
        return result;
    }

    public OptionValue dtoToEntity(OptionValueDto element) {
        OptionValue result = new OptionValue();
        BeanUtils.copyProperties(element, result);
        return result;
    }
}

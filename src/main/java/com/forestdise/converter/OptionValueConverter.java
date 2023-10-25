package com.forestdise.converter;

import com.forestdise.dto.OptionValueDTO;
import com.forestdise.entity.OptionValue;

import java.util.List;

public interface IOptionValueConverter {
    List<OptionValueDTO> entitiesToDTOs(List<OptionValue> element);
    OptionValueDTO entityToDTO(OptionValue element);
    OptionValue dtoToEntity(OptionValueDTO element);
}

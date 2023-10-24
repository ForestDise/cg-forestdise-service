package com.forestdise.converter;

import com.forestdise.dto.OptionTableDto;
import com.forestdise.dto.OptionValueDto;
import com.forestdise.entity.OptionTable;
import com.forestdise.entity.OptionValue;

import java.util.List;

public interface IOptionValueConverter {
    List<OptionValueDto> entitiesToDTOs(List<OptionValue> element);
    OptionValueDto entityToDTO(OptionValue element);
    OptionValue dtoToEntity(OptionValueDto element);
    List<OptionValue> dtosToEntities(List<OptionValueDto> element);

}

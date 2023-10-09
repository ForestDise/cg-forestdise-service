package com.forestdise.converter;

import com.forestdise.dto.ImageDto;
import com.forestdise.dto.OptionTableDto;
import com.forestdise.entity.Image;
import com.forestdise.entity.OptionTable;

import java.util.List;

public interface IOptionTableConverter {
    OptionTableDto entityToDTO(OptionTable element);

    List<OptionTableDto> entitiesToDTOs(List<OptionTable> element);

    OptionTable dtoToEntity(OptionTableDto element);
}

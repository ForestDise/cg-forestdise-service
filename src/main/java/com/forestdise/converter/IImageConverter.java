package com.forestdise.converter;

import com.forestdise.dto.ImageDto;
import com.forestdise.dto.OptionTableDto;
import com.forestdise.entity.Image;
import com.forestdise.entity.OptionTable;

import java.util.List;

public interface IImageConverter {
    ImageDto entityToDTO(Image element);

    List<ImageDto> entitiesToDTOs(List<Image> element);

    Image dtoToEntity(ImageDto element);
    List<Image> dtosToEntities(List<ImageDto> element);

}

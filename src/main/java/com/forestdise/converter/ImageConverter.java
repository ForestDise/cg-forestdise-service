package com.forestdise.converter;

import com.forestdise.dto.ImageDto;
import com.forestdise.entity.Image;

import java.util.List;

public interface ImageConverter {
    ImageDto entityToDTO(Image element);

    List<ImageDto> entitiesToDTOs(List<Image> element);

    Image dtoToEntity(ImageDto element);
}

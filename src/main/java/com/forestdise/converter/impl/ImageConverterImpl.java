package com.forestdise.converter.impl;

import com.forestdise.converter.IImageConverter;
import com.forestdise.dto.ImageDto;
import com.forestdise.entity.Image;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class ImageConverterImpl implements IImageConverter {
    @Override
    public List<ImageDto> entitiesToDTOs(List<Image> element) {
        return element.stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }
    @Override
    public ImageDto entityToDTO(Image element) {
        ImageDto result = new ImageDto();
        BeanUtils.copyProperties(element, result);
        return result;
    }
    @Override
    public Image dtoToEntity(ImageDto element) {
        Image result = new Image();
        BeanUtils.copyProperties(element, result);
        return result;
    }
}

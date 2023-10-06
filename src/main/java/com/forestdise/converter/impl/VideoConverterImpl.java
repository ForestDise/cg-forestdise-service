package com.forestdise.converter.impl;

import com.forestdise.converter.IVideoConverter;
import com.forestdise.dto.ImageDto;
import com.forestdise.dto.VideoDto;
import com.forestdise.entity.Image;
import com.forestdise.entity.Video;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class VideoConverterImpl implements IVideoConverter {
    @Override
    public List<VideoDto> entitiesToDTOs(List<Video> element) {
        return element.stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public VideoDto entityToDTO(Video element) {
        VideoDto result = new VideoDto();
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

package com.forestdise.converter.impl;

import com.forestdise.converter.VideoConverter;
import com.forestdise.dto.ImageDTO;
import com.forestdise.dto.VideoDTO;
import com.forestdise.entity.Image;
import com.forestdise.entity.Video;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class VideoConverterImpl implements VideoConverter {
    @Override
    public List<VideoDTO> entitiesToDTOs(List<Video> element) {
        return element.stream()
                .map(this::entityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public VideoDTO entityToDTO(Video element) {
        VideoDTO result = new VideoDTO();
        BeanUtils.copyProperties(element, result);
        return result;
    }

    @Override
    public Image dtoToEntity(ImageDTO element) {
        Image result = new Image();
        BeanUtils.copyProperties(element, result);
        return result;
    }
}

package com.forestdise.converter;

import com.forestdise.dto.ImageDTO;
import com.forestdise.dto.VideoDTO;
import com.forestdise.entity.Image;
import com.forestdise.entity.Video;

import java.util.List;

public interface VideoConverter {
    List<VideoDTO> entitiesToDTOs(List<Video> element);
    VideoDTO entityToDTO(Video element);
    Image dtoToEntity(ImageDTO element);
}

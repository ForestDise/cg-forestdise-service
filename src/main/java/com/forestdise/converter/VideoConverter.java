package com.forestdise.converter;

import com.forestdise.dto.ImageDto;
import com.forestdise.dto.VideoDto;
import com.forestdise.entity.Image;
import com.forestdise.entity.Video;

import java.util.List;

public interface IVideoConverter {
    List<VideoDto> entitiesToDTOs(List<Video> element);
    VideoDto entityToDTO(Video element);
    Image dtoToEntity(ImageDto element);
}

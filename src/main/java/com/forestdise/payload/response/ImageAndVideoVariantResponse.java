package com.forestdise.payload.response;

import com.forestdise.dto.ImageDto;
import com.forestdise.dto.VideoDto;
import lombok.Data;

import java.util.List;

@Data
public class ImageAndVideoVariantResponse {
    private List<ImageDto> imageDtos;
    private List<VideoDto> videoDtos;
}

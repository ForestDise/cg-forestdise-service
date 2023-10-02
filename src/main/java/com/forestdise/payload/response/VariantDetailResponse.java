package com.forestdise.payload.response;

import com.forestdise.dto.ImageDto;
import com.forestdise.dto.OptionValueDto;
import com.forestdise.dto.VideoDto;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
public class VariantDetailResponse {
    private List<ImageDto> imageDtos;
    private List<VideoDto> videoDtos;
    private Set<OptionValueDto> optionValueDtos;
}
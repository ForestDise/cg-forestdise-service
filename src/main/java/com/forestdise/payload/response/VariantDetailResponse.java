package com.forestdise.payload.response;

import com.forestdise.dto.ImageDto;
import com.forestdise.dto.OptionValueDto;
import com.forestdise.dto.VariantDto;
import com.forestdise.dto.VideoDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VariantDetailResponse {
    private List<ImageDto> imageDtos;
    private List<VideoDto> videoDtos;
    private List<OptionValueDto> optionValueDtos;
    private VariantDto variantDto;
}

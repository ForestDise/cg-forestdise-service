package com.forestdise.service;

import com.forestdise.dto.VideoDto;

import java.util.List;

public interface IVideoService {
    public List<VideoDto> getVideosByVariantId(Long variant_id);
}

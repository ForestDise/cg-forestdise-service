package com.forestdise.service;

import com.forestdise.dto.VideoDto;

import java.util.List;

public interface VideoService {
    public List<VideoDto> getVideosByVariantId(Long variant_id);
}

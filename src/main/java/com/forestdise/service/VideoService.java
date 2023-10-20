package com.forestdise.service;

import com.forestdise.dto.VideoDTO;

import java.util.List;
public interface VideoService {
    public List<VideoDTO> getVideosByVariantId(Long variant_id);
}

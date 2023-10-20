package com.forestdise.service;

import com.forestdise.dto.VideoDto;
import org.springframework.stereotype.Service;

import java.util.List;
public interface IVideoService {
    public List<VideoDto> getVideosByVariantId(Long variant_id);
}

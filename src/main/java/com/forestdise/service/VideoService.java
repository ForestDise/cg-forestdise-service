package com.forestdise.service;

import com.forestdise.dto.VideoDTO;
import com.forestdise.entity.Video;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface VideoService {
     List<VideoDTO> getVideosByVariantId(Long variant_id);
    Video createVideo (VideoDTO videoDto, Long variant_id);
}

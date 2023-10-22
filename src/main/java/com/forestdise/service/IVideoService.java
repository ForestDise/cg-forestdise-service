package com.forestdise.service;

import com.forestdise.dto.VideoDto;
import com.forestdise.entity.Video;
import org.springframework.stereotype.Service;

import java.util.List;
public interface IVideoService {
     List<VideoDto> getVideosByVariantId(Long variant_id);
    Video createVideo (VideoDto videoDto, Long variant_id);
}

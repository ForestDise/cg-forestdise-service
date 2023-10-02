package com.forestdise.service.impl;
import com.forestdise.converter.VideoConverter;
import com.forestdise.dto.VideoDto;
import com.forestdise.entity.Video;
import com.forestdise.repository.VideoRepository;
import com.forestdise.service.IVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService implements IVideoService {
    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private VideoConverter videoConverter;
    public List<VideoDto> getVideosByVariantId(Long variant_id){
        List<Video> videos = videoRepository.findVideosByVariant_Id(variant_id);
        return videoConverter.entitiesToDTOs(videos);
    }
}

package com.forestdise.service.impl;
import com.forestdise.converter.impl.VideoConverterImpl;
import com.forestdise.dto.VideoDto;
import com.forestdise.entity.Video;
import com.forestdise.repository.VideoRepository;
import com.forestdise.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private VideoConverterImpl videoConverterImpl;
    public List<VideoDto> getVideosByVariantId(Long variant_id){
        List<Video> videos = videoRepository.findVideosByVariant_Id(variant_id);
        return videoConverterImpl.entitiesToDTOs(videos);
    }
}

package com.forestdise.service.impl;
import com.forestdise.converter.impl.VideoConverterImpl;
import com.forestdise.dto.VideoDTO;
import com.forestdise.entity.Video;
import com.forestdise.repository.VideoRepository;
import com.forestdise.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {
    private final VideoRepository videoRepository;
    private final VideoConverterImpl videoConverterImpl;

    @Autowired
    public VideoServiceImpl(VideoRepository videoRepository, VideoConverterImpl videoConverterImpl) {
        this.videoRepository = videoRepository;
        this.videoConverterImpl = videoConverterImpl;
    }
    public List<VideoDTO> getVideosByVariantId(Long variant_id){
        List<Video> videos = videoRepository.findVideosByVariant_Id(variant_id);
        return videoConverterImpl.entitiesToDTOs(videos);
    }
}

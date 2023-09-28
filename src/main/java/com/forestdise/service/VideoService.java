package com.forestdise.service;

import com.forestdise.converter.ImageConverter;
import com.forestdise.converter.VideoConverter;
import com.forestdise.dto.ImageDto;
import com.forestdise.dto.VideoDto;
import com.forestdise.entity.Image;
import com.forestdise.entity.Video;
import com.forestdise.repository.ImageRepository;
import com.forestdise.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService {
    @Autowired
    private VideoRepository videoRepository;
    @Autowired
    private VideoConverter videoConverter;
    public List<VideoDto> getVideosByVariantId(Long variant_id){
        List<Video> videos = videoRepository.findVideosByVariant_Id(variant_id);
        return videoConverter.entitiesToDTOs(videos);
    }
}

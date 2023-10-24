package com.forestdise.service;

import com.forestdise.dto.ImageDto;
import com.forestdise.entity.Image;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IImageService {
    public List<ImageDto> getImageByVariantId(Long variant_id);
    public List<Image> createImage(List<ImageDto> imageDtos,Long variant_id);
}
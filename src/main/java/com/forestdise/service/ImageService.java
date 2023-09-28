package com.forestdise.service;

import com.forestdise.converter.ImageConverter;
import com.forestdise.dto.ImageDto;
import com.forestdise.entity.Image;
import com.forestdise.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private ImageConverter imageConverter;
    public List<ImageDto> getImageByVariantId(Long variant_id){
        List<Image> images = imageRepository.findImagesByVariant_Id(variant_id);
        return imageConverter.entitiesToDTOs(images);
    }
}

package com.forestdise.service.impl;

import com.forestdise.converter.impl.ImageConverterImpl;
import com.forestdise.dto.ImageDto;
import com.forestdise.entity.Image;
import com.forestdise.repository.ImageRepository;
import com.forestdise.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements IImageService {
    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private ImageConverterImpl imageConverterImpl;

    @Override
    public List<ImageDto> getImageByVariantId(Long variant_id) {
        List<Image> images = imageRepository.findImagesByVariant_Id(variant_id);
        return imageConverterImpl.entitiesToDTOs(images);
    }
}

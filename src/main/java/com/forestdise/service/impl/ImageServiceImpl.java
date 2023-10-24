package com.forestdise.service.impl;

import com.forestdise.converter.impl.ImageConverterImpl;
import com.forestdise.dto.ImageDto;
import com.forestdise.entity.Image;
import com.forestdise.entity.Variant;
import com.forestdise.repository.ImageRepository;
import com.forestdise.repository.VariantRepository;
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
    @Autowired
    private VariantRepository variantRepository;

    @Override
    public List<ImageDto> getImageByVariantId(Long variant_id) {
        List<Image> images = imageRepository.findImagesByVariant_Id(variant_id);
        return imageConverterImpl.entitiesToDTOs(images);
    }

    @Override
    public List<Image> createImage(List<ImageDto> imageDtoList, Long variant_id) {
        Variant variant = variantRepository.findById(variant_id).orElse(null);
        List<Image> images= imageConverterImpl.dtosToEntities(imageDtoList);
        for(Image element : images){
            element.setVariant(variant);
            imageRepository.save(element);
        }
        assert variant != null;
        return variant.getImages();
    }
}

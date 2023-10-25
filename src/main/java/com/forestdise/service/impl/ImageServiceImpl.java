package com.forestdise.service.impl;

import com.forestdise.converter.impl.ImageConverterImpl;
import com.forestdise.dto.ImageDTO;
import com.forestdise.entity.Image;
import com.forestdise.entity.Variant;
import com.forestdise.repository.ImageRepository;
import com.forestdise.repository.VariantRepository;
import com.forestdise.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {
    private final ImageRepository imageRepository;
    private final ImageConverterImpl imageConverterImpl;
    private final VariantRepository variantRepository;

    @Autowired
    public ImageServiceImpl(
            ImageRepository imageRepository,
            ImageConverterImpl imageConverterImpl,
            VariantRepository variantRepository
    ) {
        this.imageRepository = imageRepository;
        this.imageConverterImpl = imageConverterImpl;
        this.variantRepository = variantRepository;
    }

    @Override
    public List<ImageDTO> getImageByVariantId(Long variant_id) {
        List<Image> images = imageRepository.findImagesByVariant_Id(variant_id);
        return imageConverterImpl.entitiesToDTOs(images);
    }

    @Override
    public Image createImage(ImageDTO imageDto, Long variant_id) {
        Variant variant = variantRepository.findById(variant_id).orElse(null);
        Image image= imageConverterImpl.dtoToEntity(imageDto);
        image.setVariant(variant);
        return imageRepository.save(image);
    }
}

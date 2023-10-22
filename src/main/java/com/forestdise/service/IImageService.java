package com.forestdise.service;

import com.forestdise.dto.ImageDto;
import com.forestdise.entity.Image;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IImageService {
    public List<ImageDto> getImageByVariantId(Long variant_id);
    public Image createImage(ImageDto imageDto,Long variant_id);
}
package com.forestdise.service;

import com.forestdise.dto.ImageDto;

import java.util.List;

public interface ImageService {
    public List<ImageDto> getImageByVariantId(Long variant_id);
}
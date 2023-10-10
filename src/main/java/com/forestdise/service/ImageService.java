package com.forestdise.service;

import com.forestdise.dto.ImageDto;

import java.util.List;

public interface IImageService {
    public List<ImageDto> getImageByVariantId(Long variant_id);
}
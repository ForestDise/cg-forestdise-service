package com.forestdise.service;

import com.forestdise.dto.ImageDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IImageService {
    public List<ImageDto> getImageByVariantId(Long variant_id);
}
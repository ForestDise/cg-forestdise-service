package com.forestdise.service;

import com.forestdise.dto.ImageDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ImageService {
    public List<ImageDTO> getImageByVariantId(Long variant_id);
}
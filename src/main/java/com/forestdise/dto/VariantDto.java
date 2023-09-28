package com.forestdise.dto;

import com.forestdise.entity.Image;
import lombok.Data;

import java.util.List;

@Data
public class VariantDto {
    private Long id;
    private List<Image> images;
}

package com.forestdise.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ProductDto {
    private Long id;
    private String title;
    private String description;
    private String mainPicture;
    private String status;
    private Date createAt;
    private Date updatedAt;
    private CategoryDto category;
//    private List<VariantDto> variants;
}

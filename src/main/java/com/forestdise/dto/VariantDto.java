package com.forestdise.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class VariantDto {
    private Long id;
    private String name;
    private String skuCode;
    private int stockQuantity;
    private double weight;
    private double price;
    private double salePrice;
    private String img;
    private List<OptionValueDto> optionValueDtoList;
    private List<ImageDto> imageDtoList;
    private List<VideoDto> videoDtoList;
    private List<ReviewDto> reviewDtoList;
}

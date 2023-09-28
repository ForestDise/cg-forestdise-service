package com.forestdise.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartLineDto {
    private Long id;
    private String title;
    private String description;
    private double price;
    private String category;
    private String image;
    private int quantity;
    private String color;
}

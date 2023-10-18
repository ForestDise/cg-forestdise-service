package com.forestdise.dto;

import com.forestdise.entity.StoreCategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StoreCategoryDTO {
    private Long id;
    private String name;
    private String heroImage;
}

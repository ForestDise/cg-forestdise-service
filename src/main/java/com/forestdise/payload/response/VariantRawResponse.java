package com.forestdise.payload.response;

import com.forestdise.dto.VariantDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VariantRawResponse {
    private VariantDto variantDto;
    private String message;
}

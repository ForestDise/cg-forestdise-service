package com.forestdise.payload.response;

import com.forestdise.dto.OptionTableDto;
import com.forestdise.dto.OptionValueDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OptionValueCreateResponse {
    private List<OptionValueDto> optionValueDtoList;
    private String message;
}
package com.forestdise.payload.response;

import com.forestdise.dto.OptionTableDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OptionCreateResponse {
    private List<OptionTableDto> optionTableDtoList;
    private String message;
}

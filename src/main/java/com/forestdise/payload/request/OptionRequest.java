package com.forestdise.payload.request;

import com.forestdise.dto.OptionTableDto;
import lombok.Data;
import lombok.Getter;

import java.util.List;
@Data
public class OptionRequest {
//    private String name;
    List<String> optionNames;
}

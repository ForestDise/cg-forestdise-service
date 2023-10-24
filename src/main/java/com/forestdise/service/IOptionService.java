package com.forestdise.service;

import com.forestdise.dto.OptionTableDto;
import com.forestdise.entity.OptionTable;

import java.util.List;

public interface IOptionService {
    List<OptionTableDto> createOption ( List<OptionTableDto> optionDto, Long product_id);
}

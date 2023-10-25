package com.forestdise.service;

import com.forestdise.dto.OptionTableDTO;
import com.forestdise.entity.OptionTable;

public interface OptionService {
    OptionTable createOption (OptionTableDTO optionDto, Long product_id);
}

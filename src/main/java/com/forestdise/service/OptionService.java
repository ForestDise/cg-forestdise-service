package com.forestdise.service;

import com.forestdise.dto.OptionTableDTO;
import com.forestdise.entity.OptionTable;

public interface IOptionService {
    OptionTable createOption (OptionTableDTO optionDto, Long product_id);
}

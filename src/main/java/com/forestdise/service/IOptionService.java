package com.forestdise.service;

import com.forestdise.dto.OptionTableDto;
import com.forestdise.entity.OptionTable;

public interface IOptionService {
    OptionTable createOption (OptionTableDto optionDto,Long product_id);
}

package com.forestdise.service;
import com.forestdise.dto.OptionValueDto;

import java.util.List;

public interface IOptionValueService {
    List<OptionValueDto> getOptionValuesByVariantId(Long variant_id);
}

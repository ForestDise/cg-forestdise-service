package com.forestdise.service;
import com.forestdise.dto.OptionValueDto;

import java.util.List;

public interface OptionValueService {
    List<OptionValueDto> getOptionValuesByVariantId(Long variant_id);
}

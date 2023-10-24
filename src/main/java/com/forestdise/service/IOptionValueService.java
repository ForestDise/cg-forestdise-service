package com.forestdise.service;
import com.forestdise.dto.OptionValueDto;
import com.forestdise.entity.OptionValue;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IOptionValueService {
    List<OptionValueDto> getOptionValuesByVariantId(Long variant_id);
    List<OptionValueDto> createOptionValue(List<OptionValueDto> optionValueDto, Long product_id);
}

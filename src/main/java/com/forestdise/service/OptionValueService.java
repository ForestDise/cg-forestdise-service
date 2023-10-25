package com.forestdise.service;
import com.forestdise.dto.OptionValueDTO;
import com.forestdise.entity.OptionValue;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IOptionValueService {
    List<OptionValueDTO> getOptionValuesByVariantId(Long variant_id);
    OptionValue createOptionValue(OptionValueDTO optionValueDto, Long product_id, Long variant_id);
}

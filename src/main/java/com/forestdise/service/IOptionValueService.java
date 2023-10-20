package com.forestdise.service;
import com.forestdise.dto.OptionValueDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IOptionValueService {
    List<OptionValueDto> getOptionValuesByVariantId(Long variant_id);
}

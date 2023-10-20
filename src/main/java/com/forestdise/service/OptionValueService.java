package com.forestdise.service;
import com.forestdise.dto.OptionValueDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OptionValueService {
    List<OptionValueDTO> getOptionValuesByVariantId(Long variant_id);
}

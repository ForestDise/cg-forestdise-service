package com.forestdise.service.impl;

import com.forestdise.converter.OptionValueConverter;
import com.forestdise.dto.OptionValueDto;
import com.forestdise.entity.OptionValue;
import com.forestdise.entity.Variant;
import com.forestdise.payload.response.VariantDetailResponse;
import com.forestdise.repository.VariantRepository;
import com.forestdise.service.IOptionValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OptionValueService implements IOptionValueService {
    @Autowired
    private VariantRepository variantRepository;
    @Autowired
    private OptionValueConverter optionValueConverter;
    @Override
    public List<OptionValueDto> getOptionValuesByVariantId(Long variant_id) {
        Variant variant= variantRepository.findById(variant_id).orElse(null);
        return optionValueConverter.entitiesToDTOs(variant.getOptionValues());
    }
}

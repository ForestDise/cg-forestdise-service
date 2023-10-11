package com.forestdise.service.impl;

import com.forestdise.converter.impl.OptionValueConverterImpl;
import com.forestdise.dto.OptionValueDto;
import com.forestdise.entity.Variant;
import com.forestdise.repository.VariantRepository;
import com.forestdise.service.OptionValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OptionValueServiceImpl implements OptionValueService {
    @Autowired
    private VariantRepository variantRepository;
    @Autowired
    private OptionValueConverterImpl optionValueConverterImpl;
    @Override
    public List<OptionValueDto> getOptionValuesByVariantId(Long variant_id) {
        Variant variant= variantRepository.findById(variant_id).orElse(null);
        return optionValueConverterImpl.entitiesToDTOs(variant.getOptionValues());
    }
}

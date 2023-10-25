package com.forestdise.service.impl;

import com.forestdise.converter.impl.OptionValueConverterImpl;
import com.forestdise.dto.OptionValueDTO;
import com.forestdise.entity.OptionTable;
import com.forestdise.entity.OptionValue;
import com.forestdise.entity.Variant;
import com.forestdise.repository.OptionTableRepository;
import com.forestdise.repository.OptionValueRepository;
import com.forestdise.repository.VariantRepository;
import com.forestdise.service.OptionValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class OptionValueServiceImpl implements OptionValueService {
    private final VariantRepository variantRepository;
    private final OptionValueRepository optionValueRepository;
    private final OptionTableRepository optionTableRepository;
    private final OptionValueConverterImpl optionValueConverterImpl;


    @Autowired
    public OptionValueServiceImpl(
            VariantRepository variantRepository,
            OptionValueRepository optionValueRepository,
            OptionTableRepository optionTableRepository,
            OptionValueConverterImpl optionValueConverterImpl
    ) {
        this.variantRepository = variantRepository;
        this.optionValueRepository = optionValueRepository;
        this.optionTableRepository = optionTableRepository;
        this.optionValueConverterImpl = optionValueConverterImpl;
    }
    @Override
    public List<OptionValueDTO> getOptionValuesByVariantId(Long variant_id) {
        Variant variant= variantRepository.findById(variant_id).orElse(null);
        return optionValueConverterImpl.entitiesToDTOs(variant.getOptionValues());
    }

    @Override
    public OptionValue createOptionValue(OptionValueDTO optionValueDto, Long option_id, Long variant_id) {
        OptionValue optionValue = optionValueConverterImpl.dtoToEntity(optionValueDto) ;
        Variant variant = variantRepository.findById(variant_id).orElse(null);
        OptionTable option = optionTableRepository.findById(option_id).orElse(null);
        optionValue.setOptionTable(option);
        optionValue.getVariants().add(variant);
        variant.getOptionValues().add(optionValue);
        return optionValueRepository.save(optionValue);
    }


}

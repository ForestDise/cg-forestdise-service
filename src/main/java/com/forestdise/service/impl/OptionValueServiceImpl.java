package com.forestdise.service.impl;

import com.forestdise.converter.impl.OptionValueConverterImpl;
import com.forestdise.dto.OptionValueDto;
import com.forestdise.entity.OptionTable;
import com.forestdise.entity.OptionValue;
import com.forestdise.entity.Product;
import com.forestdise.entity.Variant;
import com.forestdise.repository.OptionTableRepository;
import com.forestdise.repository.OptionValueRepository;
import com.forestdise.repository.ProductRepository;
import com.forestdise.repository.VariantRepository;
import com.forestdise.service.IOptionValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class OptionValueServiceImpl implements IOptionValueService {
    @Autowired
    private VariantRepository variantRepository;
    @Autowired
    private OptionValueRepository optionValueRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OptionTableRepository optionTableRepository;
    @Autowired
    private OptionValueConverterImpl optionValueConverterImpl;
    @Override
    public List<OptionValueDto> getOptionValuesByVariantId(Long variant_id) {
        Variant variant= variantRepository.findById(variant_id).orElse(null);
        return optionValueConverterImpl.entitiesToDTOs(variant.getOptionValues());
    }

    @Override
    public List<OptionValueDto> createOptionValue(List<OptionValueDto> optionValueDto, Long option_id) {
        List<OptionValue> optionValue = optionValueConverterImpl.dtosToEntities(optionValueDto) ;
        OptionTable option = optionTableRepository.findById(option_id).orElse(new OptionTable());
        for(OptionValue ele : optionValue){
            ele.setOptionTable(option);
            optionValueRepository.save(ele);
        }
        List<OptionValue> optionValueList = option.getOptionValues();
        return optionValueConverterImpl.entitiesToDTOs(optionValueList);
    }


}

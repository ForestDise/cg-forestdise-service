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
    public OptionValue createOptionValue(OptionValueDto optionValueDto, Long option_id,Long variant_id) {
        OptionValue optionValue = optionValueConverterImpl.dtoToEntity(optionValueDto) ;
        Variant variant = variantRepository.findById(variant_id).orElse(null);
        OptionTable option = optionTableRepository.findById(option_id).orElse(null);
        optionValue.setOptionTable(option);
//  tạo optionvalue va variant (n-n) => tạo optionvalue thì set variant nào chứa nó, chiều ngược laại nó chua variant nào.
        optionValue.getVariants().add(variant);
        variant.getOptionValues().add(optionValue);
        return optionValueRepository.save(optionValue);
    }


}

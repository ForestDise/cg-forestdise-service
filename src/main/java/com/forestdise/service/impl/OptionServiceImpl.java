package com.forestdise.service.impl;

import com.forestdise.converter.impl.OptionTableConverterImpl;
import com.forestdise.dto.OptionTableDTO;
import com.forestdise.entity.OptionTable;
import com.forestdise.entity.Product;
import com.forestdise.repository.OptionTableRepository;
import com.forestdise.repository.ProductRepository;
import com.forestdise.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OptionServiceImpl implements OptionService {
    private final OptionTableRepository optionTableRepository;
    private final ProductRepository productRepository;
    private final OptionTableConverterImpl optionTableConverter;

    @Autowired
    public OptionServiceImpl (OptionTableRepository optionTableRepository,
                              ProductRepository productRepository,
                              OptionTableConverterImpl optionTableConverter) {
        this.optionTableRepository = optionTableRepository;
        this.productRepository = productRepository;
        this.optionTableConverter=optionTableConverter;
    }
    @Override
    public OptionTable createOption(OptionTableDTO optionDto, Long product_id) {
        Product product = productRepository.findById(product_id).orElse(null);
        OptionTable option = optionTableConverter.dtoToEntity(optionDto);
        option.setProduct(product);
        return optionTableRepository.save(option);
    }
}

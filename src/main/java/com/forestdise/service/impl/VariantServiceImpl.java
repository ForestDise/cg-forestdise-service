package com.forestdise.service.impl;

import com.forestdise.converter.impl.VariantConverterImpl;
import com.forestdise.dto.VariantDto;
import com.forestdise.entity.Variant;
import com.forestdise.repository.VariantRepository;
import com.forestdise.service.VariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VariantServiceImpl implements VariantService {
    @Autowired
    private VariantConverterImpl variantConverterImpl;
    @Autowired
    private VariantRepository variantRepository;

    public VariantDto getVariantById(Long id) {
        return variantConverterImpl.entityToDTO(variantRepository.findById(id).orElse(null));
    }

    @Transactional
    public List<VariantDto> getVariantByProductId(Long product_id) {
        List<Variant> variants = variantRepository.findByProductId(product_id);
        return variantConverterImpl.entitiesToDTOs(variants);
    }

    @Override
    public Variant findById(Long id) {
        Variant variant = variantRepository.findById(id).orElse(null);
        return variant;
    }
}

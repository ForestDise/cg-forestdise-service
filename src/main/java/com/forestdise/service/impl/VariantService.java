package com.forestdise.service.impl;

import com.forestdise.converter.VariantConverter;
import com.forestdise.dto.VariantDto;
import com.forestdise.entity.Variant;
import com.forestdise.repository.VariantRepository;
import com.forestdise.service.IVariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VariantService implements IVariantService {
    @Autowired
    private VariantConverter variantConverter;
    @Autowired
    private VariantRepository variantRepository;

    public VariantDto getVariantById(Long id) {
        return variantConverter.entityToDTO(variantRepository.findById(id).orElse(null));
    }
@Transactional
    public List<VariantDto> getVariantByProductId(Long product_id) {
        List<Variant> variants = variantRepository.findByProductId(product_id);
        return variantConverter.entitiesToDTOs(variants);
    }

}

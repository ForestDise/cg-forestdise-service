package com.forestdise.service;

import com.forestdise.converter.VariantConverter;
import com.forestdise.dto.VariantDto;
import com.forestdise.entity.Product;
import com.forestdise.entity.Variant;
import com.forestdise.repository.VariantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VariantService {
    @Autowired
    private VariantConverter variantConverter;
    @Autowired
    private VariantRepository variantRepository;
    public VariantDto getVariantById(Long id){
        return variantConverter.entityToDTO(variantRepository.findById(id).orElse(null));
    }
    public List<VariantDto> getVariantByProductId(Long product_id) {
        //VariantService lấy 1 list variant theo khóa ngoại product và convert sang 1 list variantDto
        List<Variant> variants=variantRepository.findByProductId(product_id);
        return variantConverter.entitiesToDTOs(variants);
    }

}

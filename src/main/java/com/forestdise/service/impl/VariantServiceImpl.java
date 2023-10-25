package com.forestdise.service.impl;

import com.forestdise.converter.ImageConverter;
import com.forestdise.converter.OptionValueConverter;
import com.forestdise.converter.VariantConverter;
import com.forestdise.converter.VideoConverter;
import com.forestdise.dto.*;
import com.forestdise.entity.*;
import com.forestdise.repository.OptionValueRepository;
import com.forestdise.repository.ProductRepository;
import com.forestdise.repository.VariantRepository;
import com.forestdise.service.VariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class VariantServiceImpl implements VariantService {
    @Autowired
    private VariantConverter variantConverterImpl;
    @Autowired
    private VariantRepository variantRepository;
    @Autowired
    private OptionValueConverter optionValueConverter;
    @Autowired
    private ImageConverter iImageConverter;
    @Autowired
    private VideoConverter iVideoConverter;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OptionValueRepository optionValueRepository;

    public VariantDTO getVariantById(Long id) {
        //null
        return variantConverterImpl.entityToDTO(variantRepository.findById(id).orElse(null));
    }

    @Transactional
    public List<VariantDTO> getVariantByProductId(Long product_id) {
        List<VariantDTO> variantDtoList = new ArrayList<>();
        List<Variant> variants = variantRepository.findByProduct_Id(product_id);
        for(Variant variant : variants){
            List<OptionValue> optionValueList = variant.getOptionValues();
            List<OptionValueDTO> optionValueDto = optionValueConverter.entitiesToDTOs(optionValueList);
            VariantDTO variantDto = variantConverterImpl.entityToDTO(variant);
            variantDto.setOptionValueDtoList(optionValueDto);
            variantDtoList.add(variantDto);
        }
        //if (variants != null && !variants.isEmpty()) {
    //variants = new ArrayList<>(); else{}
        return variantDtoList;
    }

    @Override
    public Variant findById(Long id) {
        Variant variant = variantRepository.findById(id).orElse(null);
        return variant;
    }
    public VariantDTO getLowestPriceVariantByProductId(Long product_id){
        List<Variant> variants = variantRepository.findByProduct_Id(product_id);
        Variant minVariant = variants.get(0);
        for(Variant variant : variants){
            if(variant.getSalePrice() < minVariant.getSalePrice()){
                minVariant = variant;
            }
        }
        List<OptionValue> optionValueList = minVariant.getOptionValues();
        List<Image> images = minVariant.getImages();
        List<Video> videos = minVariant.getVideos();
        List<OptionValueDTO> optionValueDto = optionValueConverter.entitiesToDTOs(optionValueList);
        List<ImageDTO> imageDtoList = iImageConverter.entitiesToDTOs(images);
        List<VideoDTO> videoDtoList = iVideoConverter.entitiesToDTOs(videos);
        VariantDTO variantDto = variantConverterImpl.entityToDTO(minVariant);
        variantDto.setOptionValueDtoList(optionValueDto);
        variantDto.setImageDtoList(imageDtoList);
        variantDto.setVideoDtoList(videoDtoList);
        return variantDto;
    }
    @Override
    public VariantDTO getVariantByProductPriceMin(Long product_id) {
        Variant variant = variantRepository.findTopByProductIdOrderByPriceAsc(product_id);
        return variantConverterImpl.entityToDTO(variant);
    }

    @Override
    public Variant createVariant(VariantDTO variantDto, Long product_id) {
        Variant variant= variantConverterImpl.dtoToEntity(variantDto);
        Product product = productRepository.findById(product_id).orElse(null);
        variant.setProduct(product);
        return variantRepository.save(variant);
    }

    @Override
    public Variant updateVariant(VariantDTO variantDto) {
        Variant variant = variantConverterImpl.dtoToEntity(variantDto);
        return variantRepository.save(variant);
    }
    @Override
    public void deleteVariant(Long variantId) {
        variantRepository.deleteById(variantId);
    }

    @Override
    public VariantDTO createRawVariant(List<Long> valueIdList, Long productId) {
        List<OptionValue> optionValueList = new ArrayList<>();
        for(Long ele : valueIdList){
            OptionValue optionValue = optionValueRepository.findById(ele).orElse(new OptionValue());
            optionValueList.add(optionValue);
        }
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("product not found"));
        Variant variant = new Variant();
        variant.setProduct(product);
        variant.setOptionValues(optionValueList);
        variantRepository.save(variant);
        List<OptionValue> optionValues = variant.getOptionValues();
        List<OptionValueDTO> optionValueDtoList = optionValueConverter.entitiesToDTOs(optionValues);
        VariantDTO variantDto = variantConverterImpl.entityToDTO(variant);
        variantDto.setOptionValueDtoList(optionValueDtoList);
        return variantDto;
    }
}

package com.forestdise.service.impl;

import com.forestdise.converter.IImageConverter;
import com.forestdise.converter.IOptionValueConverter;
import com.forestdise.converter.IVariantConverter;
import com.forestdise.converter.IVideoConverter;
import com.forestdise.dto.*;
import com.forestdise.entity.*;
import com.forestdise.repository.ProductRepository;
import com.forestdise.repository.VariantRepository;
import com.forestdise.service.IVariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class VariantServiceImpl implements IVariantService {
    @Autowired
    private IVariantConverter variantConverterImpl;
    @Autowired
    private VariantRepository variantRepository;
    @Autowired
    private IOptionValueConverter optionValueConverter;
    @Autowired
    private IImageConverter iImageConverter;
    @Autowired
    private IVideoConverter iVideoConverter;
    @Autowired
    private ProductRepository productRepository;

    public VariantDto getVariantById(Long id) {
        //null
        return variantConverterImpl.entityToDTO(variantRepository.findById(id).orElse(null));
    }

    @Transactional
    public List<VariantDto> getVariantByProductId(Long product_id) {
        List<VariantDto> variantDtoList = new ArrayList<>();
        List<Variant> variants = variantRepository.findByProduct_Id(product_id);
        for(Variant variant : variants){
            List<OptionValue> optionValueList = variant.getOptionValues();
            List<OptionValueDto> optionValueDto = optionValueConverter.entitiesToDTOs(optionValueList);
            VariantDto variantDto = variantConverterImpl.entityToDTO(variant);
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
    public VariantDto getLowestPriceVariantByProductId(Long product_id){
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
        List<OptionValueDto> optionValueDto = optionValueConverter.entitiesToDTOs(optionValueList);
        List<ImageDto> imageDtoList = iImageConverter.entitiesToDTOs(images);
        List<VideoDto> videoDtoList = iVideoConverter.entitiesToDTOs(videos);
        VariantDto variantDto = variantConverterImpl.entityToDTO(minVariant);
        variantDto.setOptionValueDtoList(optionValueDto);
        variantDto.setImageDtoList(imageDtoList);
        variantDto.setVideoDtoList(videoDtoList);
        return variantDto;
    }
    @Override
    public VariantDto getVariantByProductPriceMin(Long product_id) {
        Variant variant = variantRepository.findTopByProductIdOrderByPriceAsc(product_id);
        return variantConverterImpl.entityToDTO(variant);
    }

    @Override
    public Variant createVariant(VariantDto variantDto, Long product_id) {
        Variant variant= variantConverterImpl.dtoToEntity(variantDto);
        Product product = productRepository.findById(product_id).orElse(null);
        variant.setProduct(product);
        return variantRepository.save(variant);
    }

    @Override
    public Variant updateVariant(VariantDto variantDto) {
        Variant variant = variantConverterImpl.dtoToEntity(variantDto);
        return variantRepository.save(variant);
    }
    @Override
    public void deleteVariant(Long variantId) {
        variantRepository.deleteById(variantId);
    }

}

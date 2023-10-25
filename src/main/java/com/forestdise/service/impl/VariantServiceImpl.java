package com.forestdise.service.impl;

import com.forestdise.converter.ImageConverter;
import com.forestdise.converter.OptionValueConverter;
import com.forestdise.converter.VariantConverter;
import com.forestdise.converter.VideoConverter;
import com.forestdise.dto.ImageDTO;
import com.forestdise.dto.OptionValueDTO;
import com.forestdise.dto.VariantDTO;
import com.forestdise.dto.VideoDTO;
import com.forestdise.entity.Image;
import com.forestdise.entity.OptionValue;
import com.forestdise.entity.Variant;
import com.forestdise.entity.Video;
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
    private ImageConverter imageConverter;
    @Autowired
    private VideoConverter videoConverter;

    public VariantDTO getVariantById(Long id) {
        //null
        return variantConverterImpl.entityToDTO(variantRepository.findById(id).orElse(null));
    }

    @Transactional
    public List<VariantDTO> getVariantByProductId(Long product_id) {
        List<VariantDTO> variantDTOList = new ArrayList<>();
        List<Variant> variants = variantRepository.findByProduct_Id(product_id);
        for(Variant variant : variants){
            List<OptionValue> optionValueList = variant.getOptionValues();
            List<OptionValueDTO> optionValueDto = optionValueConverter.entitiesToDTOs(optionValueList);
            VariantDTO variantDto = variantConverterImpl.entityToDTO(variant);
            variantDto.setOptionValueDTOList(optionValueDto);
            variantDTOList.add(variantDto);
        }
        //if (variants != null && !variants.isEmpty()) {
    //variants = new ArrayList<>(); else{}
        return variantDTOList;
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
        List<ImageDTO> imageDTOList = imageConverter.entitiesToDTOs(images);
        List<VideoDTO> videoDTOList = videoConverter.entitiesToDTOs(videos);
        VariantDTO variantDto = variantConverterImpl.entityToDTO(minVariant);
        variantDto.setOptionValueDTOList(optionValueDto);
        variantDto.setImageDTOList(imageDTOList);
        variantDto.setVideoDTOList(videoDTOList);
        return variantDto;
    }
    @Override
    public VariantDTO getVariantByProductPriceMin(Long product_id) {
        Variant variant = variantRepository.findTopByProductIdOrderByPriceAsc(product_id);
        return variantConverterImpl.entityToDTO(variant);
    }



}

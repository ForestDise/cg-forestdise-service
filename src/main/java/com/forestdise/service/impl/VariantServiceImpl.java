package com.forestdise.service.impl;

import com.forestdise.converter.IImageConverter;
import com.forestdise.converter.IOptionValueConverter;
import com.forestdise.converter.IVariantConverter;
import com.forestdise.converter.IVideoConverter;
import com.forestdise.converter.impl.OptionValueConverterImpl;
import com.forestdise.converter.impl.VariantConverterImpl;
import com.forestdise.dto.ImageDto;
import com.forestdise.dto.OptionValueDto;
import com.forestdise.dto.VariantDto;
import com.forestdise.dto.VideoDto;
import com.forestdise.entity.Image;
import com.forestdise.entity.OptionValue;
import com.forestdise.entity.Variant;
import com.forestdise.entity.Video;
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



}

package com.forestdise.service.impl;

import com.forestdise.converter.ImageConverter;
import com.forestdise.converter.OptionValueConverter;
import com.forestdise.converter.VariantConverter;
import com.forestdise.converter.VideoConverter;
import com.forestdise.dto.*;
import com.forestdise.entity.*;
import com.forestdise.repository.ProductRepository;
import com.forestdise.repository.VariantRepository;
import com.forestdise.service.VariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class VariantServiceImpl implements VariantService {
    private final VariantConverter variantConverterImpl;
    private final VariantRepository variantRepository;
    private final OptionValueConverter optionValueConverter;
    private final ImageConverter imageConverter;
    private final VideoConverter videoConverter;
    private final ProductRepository productRepository;

    @Autowired
    public VariantServiceImpl(
            VariantConverter variantConverterImpl,
            VariantRepository variantRepository,
            OptionValueConverter optionValueConverter,
            ImageConverter imageConverter,
            VideoConverter videoConverter,
            ProductRepository productRepository
    ) {
        this.variantConverterImpl = variantConverterImpl;
        this.variantRepository = variantRepository;
        this.optionValueConverter = optionValueConverter;
        this.imageConverter = imageConverter;
        this.videoConverter = videoConverter;
        this.productRepository = productRepository;
    }

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
    public Page<VariantDTO> getVariantsByContaining(String text, Pageable pageable){
        Page<Variant> variantPage = variantRepository.findByNameContaining(text, pageable);
        return variantPage.map(variantConverterImpl::entityToDTO);
    }

    @Override
    public Page<VariantDTO> getVariantsByNameContainingAndPriceBetween(String text, double minPrice, double maxPrice, Pageable pageable ) {
        Page<Variant> variantPage = variantRepository.findVariantsByNameContainingAndPriceBetween(text,minPrice,maxPrice,pageable);
        return variantPage.map(variantConverterImpl::entityToDTO);
    }
    @Override
    public Page<VariantDTO> getVariantsBySearchTextAndRating(String text, long star, Pageable pageable) {
        List<VariantDTO> variantList = new ArrayList<>();
        Page<Variant> variantPage = variantRepository.findByNameContaining(text, pageable);
        if (variantPage!=null){
            for (Variant variant : variantPage) {
                long rating = Math.round(variantRepository.findAverageStarByReview(variant));
                if (rating == star) {
                variantList.add(variantConverterImpl.entityToDTO(variant));
                }
            }
        }
        return new PageImpl<>(variantList, pageable, variantPage.getTotalElements());
    }
}

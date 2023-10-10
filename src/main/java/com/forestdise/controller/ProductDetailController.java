package com.forestdise.controller;

import com.forestdise.dto.ImageDto;
import com.forestdise.dto.OptionValueDto;
import com.forestdise.dto.VariantDto;
import com.forestdise.dto.VideoDto;
import com.forestdise.payload.response.VariantDetailResponse;
import com.forestdise.payload.response.ProductDetailResponse;
import com.forestdise.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/product-detail")
public class ProductDetailController {
    @Autowired
    private ImageServiceImpl imageServiceImpl;
    @Autowired
    private ProductServiceImpl productServiceImpl;
    @Autowired
    private ProductAttributeServiceImpl productAttributeServiceImpl;
    @Autowired
    private VariantServiceImpl variantServiceImpl;
    @Autowired
    private VideoServiceImpl videoServiceImpl;
    @Autowired
    private OptionValueServiceImpl optionValueServiceImpl;
    ProductDetailResponse productDetailResponse=new ProductDetailResponse();
    VariantDetailResponse variantDetailResponse =new VariantDetailResponse();
    @GetMapping("/{product_id}")
    public ResponseEntity<ProductDetailResponse> getProductDetail(@PathVariable("product_id") Long productId) {
        productDetailResponse.setProductDTO(productServiceImpl.getProductById(productId));
        productDetailResponse.setVariantDtos(variantServiceImpl.getVariantByProductId(productId));
        productDetailResponse.setProductAttributeDtos(productAttributeServiceImpl.getProductAttributeByProductId(productId));
        return ResponseEntity.ok(productDetailResponse);
    }
    @GetMapping("/{product_id}/{variant_id}")
    public ResponseEntity<VariantDetailResponse> getImageVariant(@PathVariable("variant_id") Long variantId){
        List<ImageDto> images = imageServiceImpl.getImageByVariantId(variantId);
        List<VideoDto> videos = videoServiceImpl.getVideosByVariantId(variantId);
        VariantDto variantDto = variantServiceImpl.getVariantById(variantId);
        List<OptionValueDto> optionValueDtos= optionValueServiceImpl.getOptionValuesByVariantId(variantId);
        variantDetailResponse.setVariantDto(variantDto);
        variantDetailResponse.setImageDtos(images);
        variantDetailResponse.setVideoDtos(videos);
        variantDetailResponse.setOptionValueDtos(optionValueDtos);
        return ResponseEntity.ok(variantDetailResponse);
    }
}

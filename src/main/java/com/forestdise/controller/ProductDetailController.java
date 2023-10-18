package com.forestdise.controller;

import com.forestdise.dto.ImageDto;
import com.forestdise.dto.OptionValueDto;
import com.forestdise.dto.VariantDto;
import com.forestdise.dto.VideoDto;
import com.forestdise.payload.response.ProductDetailResponse;
import com.forestdise.payload.response.VariantDetailResponse;
import com.forestdise.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/product-detail")
public class ProductDetailController {
    @Autowired
    private IImageService imageServiceImpl;
    @Autowired
    private IProductService productServiceImpl;
    @Autowired
    private IProductAttributeService productAttributeServiceImpl;
    @Autowired
    private IVariantService variantServiceImpl;
    @Autowired
    private IVideoService videoServiceImpl;
    @Autowired
    private IOptionValueService optionValueServiceImpl;
    ProductDetailResponse productDetailResponse=new ProductDetailResponse();
    VariantDetailResponse variantDetailResponse =new VariantDetailResponse();
    @GetMapping("/{product_id}")
    public ResponseEntity<ProductDetailResponse> getProduct(@PathVariable("product_id") Long productId) {
        productDetailResponse.setProductDTO(productServiceImpl.getProductById(productId));
        productDetailResponse.setStoreDto(productServiceImpl.getStoreByProductId(productId));
        productDetailResponse.setOptionTableDto(productServiceImpl.getOptionsByProductId(productId));
        productDetailResponse.setVariantDtoList(variantServiceImpl.getVariantByProductId(productId));
        productDetailResponse.setProductAttributeDtoList(productAttributeServiceImpl.getProductAttributeByProductId(productId));
        productDetailResponse.setVariantDto(variantServiceImpl.getLowestPriceVariantByProductId(productId));
        // lay variant lowest price by productId
        return ResponseEntity.ok(productDetailResponse);
    }
    @GetMapping("/{product_id}/{variant_id}")
    public ResponseEntity<VariantDetailResponse> getVariant(@PathVariable("variant_id") Long variantId){
        List<ImageDto> images = imageServiceImpl.getImageByVariantId(variantId);
        List<VideoDto> videos = videoServiceImpl.getVideosByVariantId(variantId);
        VariantDto variantDto = variantServiceImpl.getVariantById(variantId);
        List<OptionValueDto> optionValueDtoList= optionValueServiceImpl.getOptionValuesByVariantId(variantId);
        variantDetailResponse.setVariantDto(variantDto);
        variantDetailResponse.setImageDtos(images);
        variantDetailResponse.setVideoDtos(videos);
        variantDetailResponse.setOptionValueDtos(optionValueDtoList);
        return ResponseEntity.ok(variantDetailResponse);
    }
}

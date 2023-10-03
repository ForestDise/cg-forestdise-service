package com.forestdise.controller;

import com.forestdise.dto.ImageDto;
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
@RequestMapping("/api/product-detail")
public class ProductDetailController {
    @Autowired
    private ImageService imageService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductAttributeService productAttributeService;
    @Autowired
    private VariantService variantService;
    @Autowired
    private VideoService videoService;
    ProductDetailResponse productDetailResponse=new ProductDetailResponse();
    VariantDetailResponse variantDetailResponse =new VariantDetailResponse();
    @GetMapping("/{product_id}")
    public ResponseEntity<ProductDetailResponse> getProductDetail(@PathVariable("product_id") Long productId) {
        productDetailResponse.setProductDTO(productService.getProductById(productId));
        productDetailResponse.setVariantDtos(variantService.getVariantByProductId(productId));
//        productDetailResponse.setProductAttributeDtos(productAttributeService.getProductAttributeByProductId(productId));
        return ResponseEntity.ok(productDetailResponse);
    }
    @GetMapping("/{product_id}/{variant_id}")
    public ResponseEntity<VariantDetailResponse> getImageVariant(@PathVariable("variant_id") Long variantId){
        List<ImageDto> images = imageService.getImageByVariantId(variantId);
        List<VideoDto> videos = videoService.getVideosByVariantId(variantId);
        VariantDto variantDto = variantService.getVariantById(variantId);
        variantDetailResponse.setVariantDto(variantDto);
        variantDetailResponse.setImageDtos(images);
        variantDetailResponse.setVideoDtos(videos);
        return ResponseEntity.ok(variantDetailResponse);
    }
}

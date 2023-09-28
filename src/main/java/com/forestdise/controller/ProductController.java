package com.forestdise.controller;

import com.forestdise.dto.ImageDto;
import com.forestdise.dto.VideoDto;
import com.forestdise.payload.response.ImageAndVideoVariantResponse;
import com.forestdise.payload.response.ProductDetailResponse;
import com.forestdise.service.ImageService;
import com.forestdise.service.ProductService;
import com.forestdise.service.VariantService;
import com.forestdise.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ProductDetail/{product_id}")
public class ProductController {
    @Autowired
    private ImageService imageService;
    @Autowired
    private ProductService productService;
    @Autowired
    private VariantService variantService;
    @Autowired
    private VideoService videoService;
    ProductDetailResponse productDetailResponse;
    ImageAndVideoVariantResponse imageAndVideoVariantResponse;
    @GetMapping()
    public ResponseEntity<ProductDetailResponse> getProductDetail(@PathVariable("product_id") Long productId) {
        productDetailResponse.setProductDTO(productService.getProductById(productId));
        productDetailResponse.setVariantDtos(variantService.getVariantByProductId(productId));
        return ResponseEntity.ok(productDetailResponse);
    }
    @GetMapping("/{variant_id}")
    public ResponseEntity<ImageAndVideoVariantResponse> getImageVariant(@PathVariable("variant_id") Long variantId){
        List<ImageDto> images = imageService.getImageByVariantId(variantId);
        List<VideoDto> videos = videoService.getVideosByVariantId(variantId);
        imageAndVideoVariantResponse.setImageDtos(images);
        imageAndVideoVariantResponse.setVideoDtos(videos);
        return ResponseEntity.ok(imageAndVideoVariantResponse);
    }
}

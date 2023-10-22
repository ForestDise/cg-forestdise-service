package com.forestdise.controller;

import com.forestdise.dto.*;
import com.forestdise.entity.Product;
import com.forestdise.payload.request.ProductRequest;
import com.forestdise.payload.response.ProductDetailResponse;
import com.forestdise.payload.response.VariantDetailResponse;
import com.forestdise.service.*;
import com.forestdise.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
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
    @PostMapping("/create")
    public ResponseEntity<Product> createProduct(@RequestBody ProductRequest productRequest) {
        ProductDto productDto =ProductDto.builder()
                .title(productRequest.getTitle())
                .status("ACTIVE")
                .createAt(Calendar.getInstance().getTime()) // lay thoi gian hien tai
                .updatedAt(Calendar.getInstance().getTime())
                .description(productRequest.getDescription())
                .mainPicture(productRequest.getMainPicture())
                .build();


        Product product = productServiceImpl.createProduct(productDto);

        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(product, HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/update/{product_id}")
    public ResponseEntity<String> updateProduct(@PathVariable("product_id") Long productId, @RequestBody ProductRequest productRequest) {
        ProductDto productDto = productServiceImpl.getProductById(productId);

        if (productDto == null) {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }

        // Cập nhật thông tin sản phẩm từ productRequest
        productDto.setTitle(productRequest.getTitle());
        productDto.setDescription(productRequest.getDescription());
        productDto.setMainPicture(productRequest.getMainPicture());
        productDto.setStatus("currently for sale");
        productDto.setCreateAt(Calendar.getInstance().getTime());
        productDto.setUpdatedAt(Calendar.getInstance().getTime());

        Product updatedProduct = productServiceImpl.updateProduct(productDto);

        if (updatedProduct != null) {
            return new ResponseEntity<>("Product updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to update product", HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/delete/{product_id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("product_id") Long productId) {
        ProductDto productDto = productServiceImpl.getProductById(productId);

        if (productDto == null) {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }

        try {
            productServiceImpl.deleteProduct(productId);
            return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to delete product", HttpStatus.BAD_REQUEST);
        }
    }
}

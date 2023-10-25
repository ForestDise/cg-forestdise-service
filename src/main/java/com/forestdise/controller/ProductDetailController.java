package com.forestdise.controller;

import com.forestdise.dto.*;
import com.forestdise.entity.Product;
import com.forestdise.payload.request.ProductRequest;
import com.forestdise.payload.response.ProductDetailResponse;
import com.forestdise.payload.response.VariantDetailResponse;
import com.forestdise.service.*;
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
    private final ImageService imageServiceImpl;
    private final ProductService productServiceImpl;
    private final ProductAttributeService productAttributeServiceImpl;
    private final VariantService variantServiceImpl;
    private final VideoService videoServiceImpl;

    private final OptionValueService optionValueServiceImpl;
    @Autowired
    public ProductDetailController(ImageService imageServiceImpl,
                                           ProductService productServiceImpl,
                                           ProductAttributeService productAttributeServiceImpl,
                                           VariantService variantServiceImpl,
                                           VideoService videoServiceImpl,
                                           OptionValueService optionValueServiceImpl) {
        this.imageServiceImpl =imageServiceImpl;
        this.productServiceImpl= productServiceImpl;
        this.productAttributeServiceImpl=productAttributeServiceImpl;
        this.variantServiceImpl=variantServiceImpl;
        this.videoServiceImpl=videoServiceImpl;
        this.optionValueServiceImpl=optionValueServiceImpl;
    }

    ProductDetailResponse productDetailResponse=new ProductDetailResponse();
    VariantDetailResponse variantDetailResponse =new VariantDetailResponse();

    @GetMapping("/{product_id}")
    public ResponseEntity<ProductDetailResponse> getProduct(@PathVariable("product_id") Long productId) {
        productDetailResponse.setProductDTO(productServiceImpl.getProductById(productId));
        productDetailResponse.setStoreDto(productServiceImpl.getStoreByProductId(productId));
        productDetailResponse.setOptionTableDto(productServiceImpl.getOptionsByProductId(productId));
        productDetailResponse.setVariantDTOList(variantServiceImpl.getVariantByProductId(productId));
        productDetailResponse.setProductAttributeDTOList(productAttributeServiceImpl.getProductAttributeByProductId(productId));
        productDetailResponse.setVariantDto(variantServiceImpl.getLowestPriceVariantByProductId(productId));
        // lay variant lowest price by productId
        return ResponseEntity.ok(productDetailResponse);
    }
    @GetMapping("/{product_id}/{variant_id}")
    public ResponseEntity<VariantDetailResponse> getVariant(@PathVariable("variant_id") Long variantId){
        List<ImageDTO> images = imageServiceImpl.getImageByVariantId(variantId);
        List<VideoDTO> videos = videoServiceImpl.getVideosByVariantId(variantId);
        VariantDTO variantDto = variantServiceImpl.getVariantById(variantId);
        List<OptionValueDTO> optionValueDTOList = optionValueServiceImpl.getOptionValuesByVariantId(variantId);
        variantDetailResponse.setVariantDto(variantDto);
        variantDetailResponse.setImageDTOS(images);
        variantDetailResponse.setVideoDTOS(videos);
        variantDetailResponse.setOptionValueDTOS(optionValueDTOList);
        return ResponseEntity.ok(variantDetailResponse);
    }
    @PostMapping("/create")
    public ResponseEntity<String> createProduct(@RequestBody ProductRequest productRequest) {
        ProductDTO productDto = ProductDTO.builder()
                .title(productRequest.getTitle())
                .status("currently for sale")
                .createAt(Calendar.getInstance().getTime())
                .updatedAt(Calendar.getInstance().getTime())
                .description(productRequest.getDescription())
                .mainPicture(productRequest.getMainPicture())
                .build();


        Product product = productServiceImpl.createProduct(productDto);

        if (product != null) {
            return new ResponseEntity<>("Product created successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to create product", HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/update/{product_id}")
    public ResponseEntity<String> updateProduct(@PathVariable("product_id") Long productId, @RequestBody ProductRequest productRequest) {
        ProductDTO productDto = productServiceImpl.getProductById(productId);

        if (productDto == null) {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        }

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
        ProductDTO productDto = productServiceImpl.getProductById(productId);

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

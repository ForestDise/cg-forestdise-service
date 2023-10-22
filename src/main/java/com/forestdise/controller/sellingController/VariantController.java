package com.forestdise.controller.sellingController;


import com.forestdise.dto.VariantDto;
import com.forestdise.entity.Variant;
import com.forestdise.payload.request.VariantRequest;
import com.forestdise.payload.response.VariantCreateResponse;
import com.forestdise.service.impl.VariantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/variant/{product_id}")
public class VariantController {
    private final VariantServiceImpl variantService;

    @Autowired
    public VariantController(VariantServiceImpl variantService ) {
        this.variantService = variantService;
    }
    @PostMapping("/create")
    public ResponseEntity<VariantCreateResponse> createVariant(@RequestBody VariantRequest variantRequest,@PathVariable("product_id") Long product_id){
        VariantCreateResponse variantCreateResponse= new VariantCreateResponse();
        VariantDto variantDto = VariantDto.builder()
                .name(variantRequest.getName())
                .skuCode(variantRequest.getSkuCode())
                .stockQuantity(variantRequest.getStockQuantity())
                .weight(variantRequest.getWeight())
                .price(variantRequest.getPrice())
                .salePrice(variantRequest.getSalePrice())
                .img(variantRequest.getImg())
                .build();

         Variant variant =variantService.createVariant(variantDto,product_id);

        if (variant != null) {
            variantCreateResponse.setMessage("Variant created successfully");
            variantCreateResponse.setVariant_id(variant.getId());
            return new ResponseEntity<>(variantCreateResponse, HttpStatus.CREATED);
        } else {
            variantCreateResponse.setMessage("Failed to create Variant");
            return new ResponseEntity<>(variantCreateResponse,HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/update/{variant_id}")
    public ResponseEntity<String> updateVariant(@PathVariable("variant_id") Long variant_id,@RequestBody VariantRequest variantRequest){
        VariantDto variantDto = variantService.getVariantById(variant_id);
        if (variantDto == null) {
            return new ResponseEntity<>("Variant not found", HttpStatus.NOT_FOUND);
        }
        variantDto = VariantDto.builder()
                .name(variantRequest.getName())
                .skuCode(variantRequest.getSkuCode())
                .stockQuantity(variantRequest.getStockQuantity())
                .weight(variantRequest.getWeight())
                .price(variantRequest.getPrice())
                .salePrice(variantRequest.getSalePrice())
                .img(variantRequest.getImg())
                .build();

        Variant variant =variantService.updateVariant(variantDto);
        if (variant != null) {
            return new ResponseEntity<>("Variant updated successfully", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("Failed to update Variant",HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/delete/{variant_id}")
    public ResponseEntity<String> deleteVariant(@PathVariable("variant_id") Long variant_Id) {
        VariantDto variantDto = variantService.getVariantById(variant_Id);

        if (variantDto == null) {
            return new ResponseEntity<>("Variant not found", HttpStatus.NOT_FOUND);
        }

        try {
            variantService.deleteVariant(variant_Id);
            return new ResponseEntity<>("Variant deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to delete Variant", HttpStatus.BAD_REQUEST);
        }
    }
}

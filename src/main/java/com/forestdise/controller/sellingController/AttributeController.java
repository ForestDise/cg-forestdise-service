package com.forestdise.controller.sellingController;

import com.forestdise.dto.ProductAttributeDto;
import com.forestdise.entity.ProductAttribute;
import com.forestdise.payload.request.ProductAttributeRequest;
import com.forestdise.payload.response.ProductAttributeResponse;
import com.forestdise.service.IProductAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/attribute/{product_id}")
public class AttributeController {
    @Autowired
    private IProductAttributeService iProductAttributeService;
    @PostMapping
    public ResponseEntity<ProductAttributeResponse> createProductAttribute(@RequestBody ProductAttributeRequest productAttributeRequest, @PathVariable Long product_id){
        ProductAttributeResponse productAttributeResponse = new ProductAttributeResponse();
        List<ProductAttributeDto> productAttributeDtoList = productAttributeRequest.getProductAttributeDtoList();
        List<ProductAttribute> productAttributeList = iProductAttributeService.createProductAttribute(productAttributeDtoList, product_id);
        if(productAttributeList.size() > 0){
            productAttributeResponse.setMessage("successfully");
            return new ResponseEntity<>(productAttributeResponse, HttpStatus.OK);
        } else {
            productAttributeResponse.setMessage("fail to create");
            return new ResponseEntity<>(productAttributeResponse, HttpStatus.BAD_REQUEST);

        }


    }
}

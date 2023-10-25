package com.forestdise.controller;

import com.forestdise.dto.ProductDTO;
import com.forestdise.dto.VariantDTO;
import com.forestdise.payload.response.SearchResponse;
import com.forestdise.service.impl.ProductServiceImpl;
import com.forestdise.service.impl.VariantServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/search/products")
public class SearchController {
    private  SearchResponse searchResponse =new SearchResponse();
    private final ProductServiceImpl productService;
    private final VariantServiceImpl variantService;
    @Autowired
    public SearchController(ProductServiceImpl productService,
                            VariantServiceImpl variantService) {
        this.productService = productService;
        this.variantService = variantService;
    }

    @GetMapping()
    public ResponseEntity<SearchResponse> getProductsByPrice(@RequestParam("searchText")String searchText) {

        List<ProductDTO> productDTOList = productService.getProductsByContaining(searchText);
        searchResponse.setProductDTOS(productDTOList);
        List<VariantDTO> variantDTOList = new ArrayList<>();
        productDTOList.forEach(productDto -> {
            VariantDTO variantDto= variantService.getVariantByProductPriceMin(productDto.getId());

            variantDTOList.add(variantDto);
        });
        searchResponse.setProductDTOS(productDTOList);
        searchResponse.setVariantDTOS(variantDTOList);
        return ResponseEntity.ok(searchResponse);
    }
}

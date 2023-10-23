package com.forestdise.controller;

import com.forestdise.dto.ProductDto;
import com.forestdise.dto.VariantDto;
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
    private final ProductServiceImpl productService;
    private final VariantServiceImpl variantService;
    @Autowired
    public SearchController(ProductServiceImpl productService,
                            VariantServiceImpl variantService) {
        this.productService = productService;
        this.variantService = variantService;
    }

    @GetMapping()
    public ResponseEntity<SearchResponse> getProductsByPrice(
            @RequestParam("searchText") String searchText,
            @RequestParam(name = "page", defaultValue = "1") int page,
            @RequestParam(name = "pageSize", defaultValue = "10") int pageSize
    ) {
        SearchResponse searchResponse =new SearchResponse();
        List<ProductDto> productDtoList = productService.getProductsByContaining(searchText);
        searchResponse.setProductDtos(productDtoList);
        List<VariantDto> variantDtoList = new ArrayList<>();
        productDtoList.forEach(productDto -> {
            VariantDto variantDto= variantService.getVariantByProductPriceMin(productDto.getId());

            variantDtoList.add(variantDto);
        });
        searchResponse.setProductDtos(productDtoList);
        searchResponse.setVariantDtos(variantDtoList);
        return ResponseEntity.ok(searchResponse);
    }
}

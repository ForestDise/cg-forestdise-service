package com.forestdise.controller;


import com.forestdise.dto.ProductDTO;
import com.forestdise.dto.StoreDTO;
import com.forestdise.repository.ProductRepository;
import com.forestdise.repository.StoreRepository;
import com.forestdise.service.ProductService;
import com.forestdise.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/stores")
public class StoreController {
    @Autowired
    StoreService storeService;
    @Autowired
    StoreRepository storeRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductService productService;

    @GetMapping("/{store_id}")
    public ResponseEntity<StoreDTO> getStore(@PathVariable("store_id") Long storeId) {
        StoreDTO storeDto = storeService.findStore(storeId);
        return new ResponseEntity<>(storeDto, HttpStatus.OK);
    }

//    @GetMapping("/{store_id}/search")
//    public ResponseEntity<List<ProductDTO>> getProductsByName(@RequestParam("name")String searchText, @PathVariable("store_id") Long storeId){
//        List<ProductDTO> productDTOList = productService.getProductsOfStoreByContaining(storeId, searchText);
//        return new ResponseEntity<>(productDTOList, HttpStatus.OK);
//    }


}

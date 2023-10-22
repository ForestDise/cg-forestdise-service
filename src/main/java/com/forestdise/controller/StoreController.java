package com.forestdise.controller;

import com.forestdise.converter.IStoreConverter;
import com.forestdise.dto.StoreDto;
import com.forestdise.entity.Seller;
import com.forestdise.entity.Store;
import com.forestdise.repository.SellerRepository;
import com.forestdise.repository.StoreRepository;
import com.forestdise.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/stores")
public class StoreController {
    @Autowired
    StoreService storeService;
    @Autowired
    StoreRepository storeRepository;

    @GetMapping("/{store_id}")
    public ResponseEntity<StoreDto> getStore(@PathVariable("store_id") Long storeId) {
        StoreDto storeDto = storeService.findStore(storeId);
        return new ResponseEntity<>(storeDto, HttpStatus.OK);
    }
    @PostMapping("/create/{sellerId}")
    @Transactional
    public ResponseEntity<StoreDto> createStore(@PathVariable("sellerId") Long sellerId, @RequestBody StoreDto storeDto){
        storeDto.setHomeImage("");
        StoreDto storeDto1 = storeService.createStore(sellerId,storeDto);
        return new ResponseEntity<>(storeDto1,HttpStatus.OK);
    }



}

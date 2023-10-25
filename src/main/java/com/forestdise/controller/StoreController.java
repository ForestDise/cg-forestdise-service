package com.forestdise.controller;

import com.forestdise.dto.StoreDTO;
import com.forestdise.payload.request.AddStoreRequest;
import com.forestdise.repository.StoreRepository;
import com.forestdise.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<StoreDTO> getStore(@PathVariable("store_id") Long storeId) {
        StoreDTO storeDto = storeService.findStore(storeId);
        return new ResponseEntity<>(storeDto, HttpStatus.OK);
    }
    @PostMapping("/create/{sellerId}")
    @Transactional
    public ResponseEntity<StoreDTO> createStore(@PathVariable("sellerId") Long sellerId, @RequestBody AddStoreRequest storeDto){
        StoreDTO storeDto1 = storeService.createStore(sellerId,storeDto);
        return new ResponseEntity<>(storeDto1,HttpStatus.OK);
    }



}

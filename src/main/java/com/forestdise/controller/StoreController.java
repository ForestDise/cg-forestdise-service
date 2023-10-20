package com.forestdise.controller;

import com.forestdise.dto.StoreCategoryDTO;
import com.forestdise.dto.StoreDto;
import com.forestdise.repository.StoreRepository;
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

    @GetMapping("/{store_id}")
    public ResponseEntity<StoreDto> getStore(@PathVariable("store_id") Long storeId) {
        StoreDto storeDto = storeService.findStore(storeId);
        return new ResponseEntity<>(storeDto, HttpStatus.OK);
    }

}

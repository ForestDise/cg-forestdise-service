package com.forestdise.controller;

import com.forestdise.converter.SellerConverter;
import com.forestdise.dto.SellerDTO;
import com.forestdise.entity.Seller;
import com.forestdise.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/sellers")
public class SellerController {
    @Autowired
    private SellerRepository sellerRepository;
    @Autowired
    private SellerConverter iSellerConverter;
    @GetMapping("/{sellerId}")
    public ResponseEntity<SellerDTO> getSeller(@PathVariable Long sellerId){
        Seller seller = sellerRepository.findById(sellerId).orElseThrow(
                () -> new UsernameNotFoundException("seller not found"));
        SellerDTO sellerDto = iSellerConverter.entityToDTO(seller);
        return new ResponseEntity<>(sellerDto, HttpStatus.OK);
    }
}

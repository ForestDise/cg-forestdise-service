package com.forestdise.controller;

import com.forestdise.dto.CartLineDto;
import com.forestdise.service.ICartLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/cart-line/")
public class CartLineController {
    @Autowired
    ICartLineService cartLineService;

    @GetMapping("/get-all")
    public ResponseEntity<?> getAllCartLines(){
        List<CartLineDto> cartLineDtoList = cartLineService.findAll();
        return new ResponseEntity<>(cartLineDtoList, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCartLine(@PathVariable("id")Long id){
        cartLineService.removeCartLine(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
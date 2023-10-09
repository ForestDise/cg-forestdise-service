package com.forestdise.controller;

import com.forestdise.dto.CartLineDto;
import com.forestdise.dto.UserDTO;
import com.forestdise.service.ICartLineService;
import com.forestdise.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/cart-lines")
public class CartLineController {
    @Autowired
    ICartLineService cartLineService;

    @Autowired
    ICartService cartService;

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCartLine(@PathVariable("id")Long id){
        cartLineService.removeCartLine(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addCartLine(CartLineDto cartLineDto){
        cartLineService.saveCartLine(cartLineDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

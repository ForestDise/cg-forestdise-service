package com.forestdise.controller;

import com.forestdise.dto.UserDTO;
import com.forestdise.entity.Cart;
import com.forestdise.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/cart")
public class CartController {
    @Autowired
    ICartService cartService;

    @PostMapping
    public ResponseEntity<?> createCart(@RequestBody UserDTO userDTO){
        Cart cart = cartService.createCart(userDTO);
        return ResponseEntity.ok(cart);
    }
}

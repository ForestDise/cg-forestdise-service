package com.forestdise.controller;

import com.forestdise.dto.UserRegisterDTO;
import com.forestdise.entity.Cart;
import com.forestdise.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/cart")
@AllArgsConstructor
public class CartController {
    private CartService cartService;

    @PostMapping
    public ResponseEntity<?> createCart(@RequestBody UserRegisterDTO userDTO){
        Cart cart = cartService.createCart(userDTO);
        return ResponseEntity.ok(cart);
    }
}

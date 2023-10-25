package com.forestdise.controller;

import com.forestdise.dto.CartLineDTO;
import com.forestdise.entity.Cart;
import com.forestdise.entity.User;
import com.forestdise.payload.request.CartLineRequest;
import com.forestdise.service.CartLineService;
import com.forestdise.service.CartService;
import com.forestdise.service.UserService;
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
    CartLineService cartLineService;

    @Autowired
    CartService cartService;

    @Autowired
    UserService userService;

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCartLine(@PathVariable("id")Long cartLineId){
        cartLineService.removeCartLine(cartLineId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/add-to-cart")
    public ResponseEntity<CartLineDTO> addCartLine(@RequestBody CartLineRequest cartLineRequest){
        CartLineDTO cartLineDto = cartLineService.saveCartLine(cartLineRequest);
        return new ResponseEntity<>(cartLineDto ,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAllCartLines(@PathVariable("id") Long userId){
        User user = userService.findById(userId);
        Cart cart = cartService.findCartByUserId(user);
        List<CartLineDTO> cartLineDtos = cartLineService.findCartLinesByCartId(cart.getId());
        return new ResponseEntity<>(cartLineDtos,HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateCartLine(@RequestBody CartLineDTO cartLineDto) throws Exception {
        cartLineService.updateCartLine(cartLineDto, cartLineDto.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete-all/{id}")
    public ResponseEntity<?> deleteAllCartLine(@PathVariable("id") Long userId){
        User user = userService.findById(userId);
        Cart cart = cartService.findCartByUserId(user);
        cartLineService.removeAllCartLines(cart.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

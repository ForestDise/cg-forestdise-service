package com.forestdise.controller;

import com.forestdise.dto.CartLineDto;
import com.forestdise.dto.SaveForLaterDto;
import com.forestdise.entity.Cart;
import com.forestdise.entity.User;
import com.forestdise.service.CartService;
import com.forestdise.service.SaveForLaterService;
import com.forestdise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/save-for-later")
public class SaveForLaterController {
    @Autowired
    private SaveForLaterService saveForLaterService;

    @Autowired
    private UserService userService;

    @Autowired
    private CartService cartService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getAllSaveForLater(@PathVariable("id") Long userId){
        User user = userService.findById(userId);
        Cart cart = cartService.findCartByUserId(user);
        List<SaveForLaterDto> saveForLaterDtos = saveForLaterService.findSaveForLaterByCartId(cart.getId());
        return new ResponseEntity<>(saveForLaterDtos, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSaveForLater(@PathVariable("id") Long saveForLaterId) {
        saveForLaterService.removeSaveForLater(saveForLaterId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

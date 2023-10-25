package com.forestdise.controller;

import com.forestdise.dto.SellerLoginDTO;
import com.forestdise.dto.SellerRegisterDTO;
import com.forestdise.dto.UserLoginDTO;
import com.forestdise.dto.UserRegisterDTO;
import com.forestdise.entity.Seller;
import com.forestdise.entity.User;
import com.forestdise.service.SellerService;
import com.forestdise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api")
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private SellerService sellerService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginDTO userLoginDto) {
        String token = userService.login(userLoginDto);
        return ResponseEntity.ok(token);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRegisterDTO userRegisterDto){
        User user = userService.register(userRegisterDto);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/login/seller")
    public ResponseEntity<?> loginSeller(@RequestBody SellerLoginDTO sellerLoginDto) {
        String token = sellerService.login(sellerLoginDto);
        return ResponseEntity.ok(token);
    }

    @PostMapping("/register/seller")
    public ResponseEntity<?> registerSeller(@RequestBody SellerRegisterDTO sellerRegisterDto){
        Seller seller = sellerService.register(sellerRegisterDto);
        return ResponseEntity.ok(seller);
    }
}

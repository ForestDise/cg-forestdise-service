package com.forestdise.controller;

import com.forestdise.converter.impl.UserConverterImpl;
import com.forestdise.dto.UserDTO;
import com.forestdise.dto.UserLoginDTO;
import com.forestdise.entity.User;
import com.forestdise.payload.response.ProductDetailResponse;
import com.forestdise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConverterImpl userConverter;

    @GetMapping("/{user_id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long user_id){
        User user = userRepository.findById(user_id)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        UserDTO userDTO = userConverter.convertEntityToDTO(user);
        return ResponseEntity.ok(userDTO);
    }
}

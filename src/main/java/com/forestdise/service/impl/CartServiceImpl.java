package com.forestdise.service.impl;

import com.forestdise.dto.UserDTO;
import com.forestdise.entity.Cart;
import com.forestdise.entity.User;
import com.forestdise.repository.CartRepository;
import com.forestdise.repository.UserRepository;
import com.forestdise.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements ICartService {
    @Autowired
    CartRepository cartRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public Cart createCart(UserDTO userDTO) {
        Cart cart = new Cart();
        User user = userRepository.findById(userDTO.getId()).orElse(null);
        cart.setUser(user);
        cartRepository.save(cart);
        return cart;
    }
}

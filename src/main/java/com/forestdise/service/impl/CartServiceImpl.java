package com.forestdise.service.impl;

import com.forestdise.dto.UserRegisterDTO;
import com.forestdise.entity.Cart;
import com.forestdise.entity.User;
import com.forestdise.repository.CartRepository;
import com.forestdise.repository.UserRepository;
import com.forestdise.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    CartRepository cartRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public Cart createCart(UserRegisterDTO userDTO) {
        Cart cart = new Cart();
        User user = userRepository.findByEmail(userDTO.getEmail());
        cart.setUser(user);
        cartRepository.save(cart);
        return cart;
    }

    @Override
    public Cart findCartByUserId(User user) {
        Cart cart = cartRepository.findCartByUser(user);
        return cart;
    }

    @Override
    public Cart findById(Long id) {
        Cart cart = cartRepository.findById(id).orElse(null);
        return cart;
    }
}

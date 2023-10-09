package com.forestdise.service;

import com.forestdise.dto.UserRegisterDTO;
import com.forestdise.entity.Cart;

public interface ICartService {
    Cart createCart (UserRegisterDTO userDTO);
}

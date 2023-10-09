package com.forestdise.service;

import com.forestdise.dto.UserDTO;
import com.forestdise.entity.Cart;

public interface ICartService {
    Cart createCart (UserDTO userDTO);
}

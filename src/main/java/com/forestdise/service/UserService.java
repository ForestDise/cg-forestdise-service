package com.forestdise.service;

import com.forestdise.dto.UserRegisterDTO;
import com.forestdise.dto.UserLoginDTO;
import com.forestdise.entity.User;

import java.util.List;

public interface UserService {
    String login(UserLoginDTO userLoginDTO);
    User register(UserRegisterDTO userRegisterDTO);
    User findByEmail(String email);
    List<UserLoginDTO> findAllUsers();
    User findById (Long id);
}

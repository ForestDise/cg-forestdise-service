package com.forestdise.service;

import com.forestdise.dto.UserLoginDTO;
import com.forestdise.dto.UserRegisterDTO;
import com.forestdise.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    String login(UserLoginDTO userLoginDTO);
    User register(UserRegisterDTO userRegisterDTO);
    User findByEmail(String email);
    List<UserLoginDTO> findAllUsers();
    User findById (Long id);
}

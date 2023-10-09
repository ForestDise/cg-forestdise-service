package com.forestdise.converter;

import com.forestdise.dto.UserDTO;
import com.forestdise.dto.UserRegisterDTO;
import com.forestdise.dto.UserLoginDTO;
import com.forestdise.entity.User;

import java.util.List;

public interface IUserConverter {
    UserDTO convertEntityToDTO(User user);
    List<UserLoginDTO> convertEntitiesToDTOs(List<User> users);
}

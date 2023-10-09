package com.forestdise.converter.impl;

import com.forestdise.converter.IUserConverter;
import com.forestdise.dto.UserDTO;
import com.forestdise.dto.UserRegisterDTO;
import com.forestdise.dto.UserLoginDTO;
import com.forestdise.entity.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserConverterImpl implements IUserConverter {

    @Override
    public UserDTO convertEntityToDTO(User user) {
        UserDTO result = new UserDTO();
        BeanUtils.copyProperties(user, result);
        return result;
    }

    @Override
    public List<UserLoginDTO> convertEntitiesToDTOs(List<User> element) {
        return null;
    }
}

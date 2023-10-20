package com.forestdise.service.impl;

import com.forestdise.configuration.JwtTokenUtil;
import com.forestdise.dto.UserLoginDTO;
import com.forestdise.dto.UserRegisterDTO;
import com.forestdise.entity.Role;
import com.forestdise.entity.User;
import com.forestdise.repository.RoleRepository;
import com.forestdise.repository.UserRepository;
import com.forestdise.security.JwtUserDetailsService;
import com.forestdise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private JwtUserDetailsService jwtUserDetailsService;


    @Override
    public String login(UserLoginDTO userLoginDto) {
        User user = userRepository.findByEmail(userLoginDto.getEmail());

        if(user == null){
            throw new UsernameNotFoundException("User not found");
        }
        if(!passwordEncoder.matches(userLoginDto.getPassword(), user.getPassword())){
            throw new AuthenticationServiceException("Wrong password");
        }
        return jwtTokenUtil.generateToken(user);
    }

    @Override
    @Transactional
    public User register(UserRegisterDTO userRegisterDto) {
        jwtUserDetailsService.loadUserByUsername(userRegisterDto.getEmail());
        String password = userRegisterDto.getPassword();
        User user = new User();
        user.setClientName(userRegisterDto.getClientName());
        user.setEmail(userRegisterDto.getEmail());
        user.setPassword(passwordEncoder.encode(password));
        Role role = roleRepository.findByName("ROLE_USER");
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
        return user;
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public List<UserLoginDTO> findAllUsers() {
        return null;
    }

    @Override
    public User findById(Long id) {
        User user = userRepository.findById(id).orElse(null);
        return user;
    }
}

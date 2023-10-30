package com.forestdise.security;

import com.forestdise.constraint.Role;
import com.forestdise.entity.Seller;
import com.forestdise.entity.User;
import com.forestdise.repository.SellerRepository;
import com.forestdise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SellerRepository sellerRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);

        if (user != null) {
            throw new UsernameNotFoundException("Email has already been registered");
        }else{
                return null;
        }
    }

    public UserDetails loadSellerByEmail(String email) throws UsernameNotFoundException {
        Seller seller = sellerRepository.findByEmail(email);

        if (seller != null) {
            throw new UsernameNotFoundException("Email has already been registered");
        }else{
            return null;
        }
    }


}

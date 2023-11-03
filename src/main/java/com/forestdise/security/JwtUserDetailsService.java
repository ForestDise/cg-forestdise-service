package com.forestdise.security;

import com.forestdise.constraint.Role;
import com.forestdise.entity.Seller;
import com.forestdise.entity.User;
import com.forestdise.entity.VerificationToken;
import com.forestdise.repository.SellerRepository;
import com.forestdise.repository.UserRepository;
import com.forestdise.repository.VerificationTokenRepository;
import com.forestdise.service.EmailService;
import com.forestdise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SellerRepository sellerRepository;
    @Autowired
    private VerificationTokenRepository verificationTokenRepository;
    @Autowired
    private EmailService emailService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);

        if (user != null) {
            VerificationToken token = verificationTokenRepository.findByUser(user);
            if(user.isEnabled()){
                throw new UsernameNotFoundException("Email has already been registered");
            } else{
                boolean isExpired;
                Calendar cal = Calendar.getInstance();
                if ((token.getExpiryDate().getTime() - cal.getTime().getTime()) <= 0) {
                    isExpired = true;
                } else{
                    isExpired = false;
                }
                String tokenUID = token.getToken();
                if(isExpired){
                    emailService.sendConfirmEmail(user, tokenUID);
                    return null;
                } else {
                    throw new UsernameNotFoundException("Email has not been enabled");
                }
            }
        }else {
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

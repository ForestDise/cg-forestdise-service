package com.forestdise.configuration;

import com.forestdise.constraint.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .and()
                .addFilterBefore(jwtAuthenticationFilter, BasicAuthenticationFilter.class)
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeHttpRequests((requests) -> requests
                                .antMatchers("/api/users/**").hasAnyRole(Role.USER.toString())
                                .antMatchers("/api/sellers/**").hasAnyRole(Role.SELLER.toString())
                                .anyRequest().authenticated()
                        );
    }

    @Override
    public void configure(WebSecurity webSecurity) {
        webSecurity.ignoring().
                antMatchers("/api/register/**", "/api/login/**",
                        "/api/products", "/api/product-detail/**",
                        "/api/cart-lines/**", "/api/cart/**",
                        "/api/save-for-later/**", "/api/stores/**",
                        "/api/payments/**")
                .antMatchers(HttpMethod.GET, "/api/products", "/api/cart-lines/**","/api/search/**","/api/reviews/**");

    }
}

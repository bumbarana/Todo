package com.soa.login.config;


import com.soa.login.dto.UserDto;
import com.soa.login.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Slf4j
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private UserService userService;

    @Autowired
    public CustomAuthenticationProvider(final UserService userService) {
        this.userService = userService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        log.info("----------"+authentication);
        String email = authentication.getName();
        String password = authentication.getCredentials().toString();

        AuthenticationRequest authReq = new AuthenticationRequest();
        authReq.setEmail(email);
        authReq.setPassword(password);

        UserDto user = userService.getUser(authReq);
        ArrayList<GrantedAuthority> authorities = new ArrayList<>();

        log.info("=======authenticate"+  user);

        if(user != null){
            authorities.add(new SimpleGrantedAuthority("USER"));
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                    email, password, authorities);

            return token;
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(
                UsernamePasswordAuthenticationToken.class);
    }
}

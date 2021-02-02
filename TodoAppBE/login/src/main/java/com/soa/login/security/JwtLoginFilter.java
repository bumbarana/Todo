package com.soa.login.security;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.soa.login.config.AuthenticationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;


@Slf4j
@Component
public class JwtLoginFilter extends AbstractAuthenticationProcessingFilter {

    @Autowired
    private JwtTokenProvider tokenProvider;


    @Autowired
    public JwtLoginFilter(@Value("/login") String url, AuthenticationManager authManager, JwtTokenProvider tokenProvider) {
        super(new AntPathRequestMatcher(url));
        setAuthenticationManager(authManager);
        this.tokenProvider=tokenProvider;
        log.info("444444---- "+this.tokenProvider);
    }

    @Override
    public Authentication attemptAuthentication(
            HttpServletRequest req, HttpServletResponse res)
            throws AuthenticationException, IOException, ServletException {
        AuthenticationRequest creds = new ObjectMapper()
                .readValue(req.getInputStream(), AuthenticationRequest.class);

        log.info("creds-----  "+creds);
        String decodedEmail=new String(Base64.getDecoder().decode(creds.getEmail()));
        String decodedPassword=new String(Base64.getDecoder().decode(creds.getPassword()));

//
//        String email=creds.getEmail();
//        String password=creds.getPassword();

//        System.out.println("email:  ");
//        System.out.println(email);
//
//        System.out.println("Password: ");
//        System.out.println(password);


        log.info(decodedEmail);
        log.info(decodedPassword);

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                decodedEmail,
                decodedPassword
//                email, password
        );

        log.info("token===== "+ token);
        Authentication a = getAuthenticationManager().authenticate(token);
        log.info("a===== "+ a);
        //String jwt = tokenProvider.getAuthentication(a)
        return a;
    }

    @Override
    protected void successfulAuthentication(
            HttpServletRequest req,
            HttpServletResponse res, FilterChain chain,
            Authentication auth) throws IOException, ServletException {
        tokenProvider
                .addAuthentication(res, auth.getName(), ((GrantedAuthority)auth.getAuthorities().toArray()[0]).getAuthority());
    }
}
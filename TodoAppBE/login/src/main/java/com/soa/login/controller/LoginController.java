package com.soa.login.controller;

import com.soa.login.dto.UserDto;
import com.soa.login.helpers.constants.EndpointConstants;
import com.soa.login.repository.UserRepository;
import com.soa.login.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@CrossOrigin
public class LoginController {

   @Autowired
    private PasswordEncoder passwordEncoder;
    private UserService userHandler;
    private UserRepository userRepository;


    @Autowired
    public LoginController(final UserService userHandler, final UserRepository userRepository) {
        this.userHandler = userHandler;
        this.userRepository = userRepository;
    }

    @PostMapping(EndpointConstants.LOGIN)
    public void getUser() {

    }

    @PostMapping(EndpointConstants.REGISTER)
    public void register(@RequestBody UserDto userDto) {
        log.info("DAdsadda"+userDto);
        if(userHandler.getUserByEmail(userDto.getEmail())==null){

            userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
            userRepository.save(userDto);
        }

    }


    @Bean
    PasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }

}

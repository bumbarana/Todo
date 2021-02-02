package com.soa.login.controller;
import com.soa.login.dto.UserDto;
import com.soa.login.repository.UserRepository;
import com.soa.login.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@Slf4j
@CrossOrigin
public class UserController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    private UserService userService;



    @GetMapping("/getUser")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<Object> getStudent() {
        log.info("a intrat---------");
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        UserDto user = userRepository.findByEmail(email);

        log.info("------"+user);
        if (user != null)
            return new ResponseEntity<>(user, HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @GetMapping
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<Object> getUser() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        UserDto loggedUser = userRepository.findByEmail(email);
        if (loggedUser != null)
            return new ResponseEntity<>(loggedUser, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
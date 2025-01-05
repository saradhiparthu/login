package com.microservices.login.controller;

import com.microservices.login.domain.AuthRequest;
import com.microservices.login.entity.User;
import com.microservices.login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login/user")
public class UserController {
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private UserRepository userRepository;
    
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody AuthRequest authRequest) {
        User user = new User();
        user.setUsername(authRequest.getEmail());
        user.setPassword(passwordEncoder.encode(authRequest.getPassword())); // Store hashed password
        user.setEnabled(true);
        userRepository.save(user);
        return ResponseEntity.ok("user created");
    }

}

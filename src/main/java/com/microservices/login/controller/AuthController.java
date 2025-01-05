package com.microservices.login.controller;

import com.microservices.login.domain.AuthRequest;
import com.microservices.login.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login/oauth")
public class AuthController {

    @Lazy
    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Lazy
    @Autowired
    private JwtService jwtService;

    @PostMapping("/token")
    public String authenticate(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            Authentication authentication = authenticationProvider.
                    authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
            return jwtService.generateToken(authentication.getName());
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }

    }
}
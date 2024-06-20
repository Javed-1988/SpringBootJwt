package com.example.springbootweb.controller;

import com.example.springbootweb.model.JwtRequest;
import com.example.springbootweb.model.JwtResponse;
import com.example.springbootweb.utility.JwtUtility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class JwtTokenController {

    private final JwtUtility jwtUtility;
    private final AuthenticationManager authenticationManager;
    public JwtTokenController(JwtUtility jwtUtility, AuthenticationManager authenticationManager) {
        this.jwtUtility = jwtUtility;
        this.authenticationManager = authenticationManager;
    }


    @PostMapping("/api/v1/login")
    public JwtResponse AuthenticateAndGetToken(@RequestBody JwtRequest jwtRequest){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));

        System.out.println("hi");

        if(authentication.isAuthenticated()){
            String token=jwtUtility.GenerateToken(jwtRequest.getUsername());
            return new JwtResponse(token);

//            return JwtResponse.builder()
//                    .token(jwtUtility.GenerateToken(jwtRequest.getUsername()));


        } else {
            throw new UsernameNotFoundException("invalid user request..!!");
        }
    }
}

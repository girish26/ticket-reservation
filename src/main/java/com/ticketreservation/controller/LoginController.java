package com.ticketreservation.controller;

import com.ticketreservation.request.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import com.ticketreservation.services.CustomerServiceImpl;
import com.ticketreservation.jwt.JwtUtil;
import com.ticketreservation.services.UserServiceImpl;


import com.ticketreservation.response.AuthenticationResponse;

@RestController
@RequestMapping("/api/v1")
public class LoginController {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserServiceImpl userDetailsService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private CustomerServiceImpl customerServiceImpl;

    @GetMapping("/hello")
    public String hello() {
        return "Hello world";
    }


    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginRequest authenticationRequest) throws Exception {

        try {

            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUserId(), authenticationRequest.getPassword())
            );

        } catch (BadCredentialsException e) {
            throw new Exception("incorrect username or password", e);
        }

        UserDetails userDetails = null;
        userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUserId());
        final String jwt = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));


    }


}

package com.jwt.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.services.CustomerServiceImpl;
import com.jwt.services.JwtUtil;
import com.jwt.services.MyUserDetailsService;


import com.jwt.entities.Customer;
import com.jwt.models.AuthenticationResponse;

@RestController
public class Home {

	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtil jwtTokenUtil;
	
	@Autowired
	private CustomerServiceImpl customerServiceImpl;
	
	@GetMapping("/hello")	
	public String hello() {
		return "Hello world";
	}
	
	
	/*
	@GetMapping("/buses")
	public ResponseEntity<List<Bus>> getBusess() {
		
		List<Bus> list=busService.getAllBusses();
		if(list.size()<=0)
		
	}
	*/
	@PostMapping("/login")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody Customer authenticationRequest) throws Exception{
		
		try {
			
			authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authenticationRequest.getCustomerName(), authenticationRequest.getPassword())
			
			);
			
		}catch(BadCredentialsException e) {
			
			throw new Exception("incorrect username or password",e);
		}
	
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getCustomerName());
		
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
			
		
	}	
	
	
}

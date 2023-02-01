package com.axis.saral.service.controller;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.axis.saral.service.config.JwtUtil;
import com.axis.saral.service.entity.JwtRequest;
import com.axis.saral.service.entity.JwtResponse;
import com.axis.saral.service.service.EmployeeJwtService;



@RestController
@CrossOrigin(origins = "*")
public class JwtController {

	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	EmployeeJwtService employeeJwtService;
	
	@Autowired
	JwtUtil jwtUtil;
	
	@PostMapping("/token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
		System.out.println(jwtRequest);
		try {

			this.authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
		} catch (UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("Bad Credentials");
		} catch (BadCredentialsException e) {
			throw new Exception("Bad Credentials");
		}

		UserDetails userDetails = this.employeeJwtService.loadUserByUsername(jwtRequest.getUsername());

		String token = this.jwtUtil.generateToken(userDetails);
		System.out.println("JWT" + token);

		return ResponseEntity.ok(new JwtResponse(token));
}
}
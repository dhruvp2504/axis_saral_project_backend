package com.axis.saral.service.jwt.controller;



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

import com.axis.saral.service.jwt.model.JwtRequest;
import com.axis.saral.service.jwt.model.JwtResponse;
import com.axis.saral.service.jwt.service.CustomEmployeeDetailsService;
import com.axis.saral.service.jwt.utils.JwtUtil;

@CrossOrigin("http://localhost:3000")
@RestController
public class JwtController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private CustomEmployeeDetailsService customEmployeeDetailsService;

	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping("/token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
		System.out.println(jwtRequest);
		try {

			this.authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(jwtRequest.getUserName(), jwtRequest.getPassword()));
		} catch (UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("Bad Credentials");
		} catch (BadCredentialsException e) {
			throw new Exception("Bad Credentials");
		}

		UserDetails userDetails = this.customEmployeeDetailsService.loadUserByUsername(jwtRequest.getUserName());

		String token = this.jwtUtil.generateToken(userDetails);
		System.out.println("JWT" + token);

		return ResponseEntity.ok(new JwtResponse(token));

	}
}

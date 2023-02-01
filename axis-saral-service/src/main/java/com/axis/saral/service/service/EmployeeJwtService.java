package com.axis.saral.service.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.axis.saral.service.entity.Employee;
import com.axis.saral.service.entity.EmployeeDetails;
import com.axis.saral.service.repository.JwtRepository;

@Service
public class EmployeeJwtService implements UserDetailsService{

	@Autowired
	private JwtRepository jwtRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		final Employee employee = jwtRepository.getEmployeeByEmailId(username);
		
		if(employee == null) {
			throw new UsernameNotFoundException("User Not Found!");
		}else {
			return new EmployeeDetails(employee);
		}
	}

	
}

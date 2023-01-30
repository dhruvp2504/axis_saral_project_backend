package com.axis.saral.service.jwt.service;

import java.util.ArrayList;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.axis.saral.service.entity.Employee;
import com.axis.saral.service.repository.EmployeeRepository;

@Service
public class CustomEmployeeDetailsService implements UserDetailsService {

	@Autowired
	private EmployeeRepository employeeRepository ;
	
	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Optional<Employee> empOptional = employeeRepository.findByEmailId(emailId);
		if(!empOptional.isEmpty()) {
			Employee employee = empOptional.get();
			employee.setPassword(bCryptPasswordEncoder.encode(employee.getPassword()));
			return new User(employee.getEmailId(), employee.getPassword(), new ArrayList<>());
		}else {	
			throw new UsernameNotFoundException("Email ID not found!");
		}
	}

}

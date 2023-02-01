package com.axis.saral.service.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.axis.saral.service.entity.Employee;
import com.axis.saral.service.service.EmployeeService;

@RestController
@CrossOrigin(value = "http://localhost:3000")

public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@GetMapping("/employee/{employeeId}")
	public Employee getProjectByProjectId(@PathVariable long employeeId) {
		return employeeService.getEmployeeByEmployeeId(employeeId);
	}

	@PostMapping("/employee")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee) {
		employeeService.saveEmployee(employee);
		return new ResponseEntity<String>("Employee Id added sucessfully", HttpStatus.CREATED);
	}

	@DeleteMapping("/employee/delete/{employeeId}")
	public ResponseEntity<String> deleteProjectByProjectId(@PathVariable long employeeId) {
		employeeService.deleteEmployeeByEmployeeId(employeeId);
		return new ResponseEntity<String>("Project Id deleted: " + employeeId, HttpStatus.OK);
	}
	
	@PutMapping("/employee/update/{employeeId}")
	public ResponseEntity<String> updateEmployeeDetails(@PathVariable long employeeId,
			@RequestBody Employee updatedEmployee){
		if(employeeId != updatedEmployee.getEmployeeId()) {
			return new ResponseEntity<String>("Employee Not Found!!", HttpStatus.BAD_REQUEST);
		}else {
			employeeService.updateEmployee(employeeId, updatedEmployee);
			return new ResponseEntity<String>("Employee updated Successfully", HttpStatus.OK);
		}
	}

}

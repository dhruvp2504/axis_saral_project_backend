package com.axis.saral.service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.saral.service.entity.Employee;
import com.axis.saral.service.exception.EmployeeNotFoundException;
import com.axis.saral.service.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@Override
	public Employee getEmployeeByEmployeeId(long employeeId) {
		Optional<Employee> employeeOptional = employeeRepository.findById(employeeId);
        if ((!employeeOptional.isPresent())) {
            throw new EmployeeNotFoundException("Employee not found with Id " + employeeId);
        }
        return employeeOptional.get();	
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return (List<Employee>) employeeRepository.findAll();
	}

	@Override
	public void saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeRepository.save(employee);
	}

	@Override
	public void updateEmployee(long employeeId, Employee updatedEmployee) {
		// TODO Auto-generated method stub
		employeeRepository.save(updatedEmployee);
	}

	@Override
	public void deleteEmployeeByEmployeeId(long employeeId) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(employeeId);
	}

}

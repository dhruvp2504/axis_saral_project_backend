package com.axis.saral.service.repository;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axis.saral.service.entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Long> {
	
	Optional<Employee> findByEmailId(String emailId);
}
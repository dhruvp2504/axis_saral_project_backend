package com.axis.saral.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.axis.saral.service.entity.Employee;

@Repository
public interface JwtRepository extends JpaRepository<Employee, Long> {
	Employee getEmployeeByEmailId(String emailId);
}

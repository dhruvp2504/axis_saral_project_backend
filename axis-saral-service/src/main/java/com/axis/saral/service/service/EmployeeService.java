package com.axis.saral.service.service;

import java.util.List;

import com.axis.saral.service.entity.Employee;

public interface EmployeeService {
	 Employee getEmployeeByEmployeeId(long employeeId);
	 List<Employee>getAllEmployees();
	 void saveEmployee(Employee employee);
	 void updateEmployee(long employeeId,Employee updatedEmployee);
	 void deleteEmployeeByEmployeeId(long emplloyeeId);

}

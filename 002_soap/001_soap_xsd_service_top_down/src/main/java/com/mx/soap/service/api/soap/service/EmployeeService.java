package com.mx.soap.service.api.soap.service;

import java.util.List;

import com.mx.soap.service.api.soap.entity.Employee;

public interface EmployeeService {

	Employee addEmployee(Employee employee);

	void deleteEmployee(long employeeId);

	Employee getEmployeeById(long employeeId);

	void updateEmployee(Employee employee);
	
	List<Employee> getAllEmployees();
}

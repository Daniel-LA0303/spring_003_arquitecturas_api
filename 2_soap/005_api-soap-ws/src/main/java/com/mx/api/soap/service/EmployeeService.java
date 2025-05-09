package com.mx.api.soap.service;

import java.util.List;

import com.mx.api.soap.entity.Employee;

public interface EmployeeService {

	void addEmployee(Employee employee);

	void deleteEmployee(long employeeId);

	Employee getEmployeeById(long employeeId);

	void updateEmployee(Employee employee);
	
	List<Employee> getAllEmployees();
}

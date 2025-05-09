package com.mx.soap.employee;

import java.util.List;

import com.mx.soap.employee.dto.EmployeeDTO;
import com.mx.soap.employee.entity.Employee;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;


@WebService
public interface EmployeeWs {
	
	@WebMethod
	List<Employee> getEmployess();

	@WebMethod
	EmployeeDTO getEmployee(Long id);

	@WebMethod
	Employee createEmployee(EmployeeDTO employeeDTO);

	@WebMethod
	Employee updateEmployee(Employee employee);
	
	@WebMethod
	String deleteEmployee(Long id);

}

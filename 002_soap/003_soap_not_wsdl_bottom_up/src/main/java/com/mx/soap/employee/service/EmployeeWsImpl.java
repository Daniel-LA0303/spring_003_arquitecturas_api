package com.mx.soap.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.soap.employee.EmployeeWs;
import com.mx.soap.employee.dto.EmployeeDTO;
import com.mx.soap.employee.entity.Employee;
import com.mx.soap.employee.repository.EmployeeRepository;

@Service
public class EmployeeWsImpl implements EmployeeWs{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getEmployess() {
		return employeeRepository.findAll();
	}

	@Override
	public EmployeeDTO getEmployee(Long id) {
		
		Employee em = employeeRepository.findById(id).get();
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO = toDTO(em);
		return employeeDTO;
	}

	@Override
	public Employee createEmployee(EmployeeDTO employeeDTO) {
		
		Employee employee = new Employee();
		employee.setAddress(employeeDTO.getAddress());
		employee.setDepartment(employeeDTO.getDepartment());
		employee.setName(employeeDTO.getName());
		employee.setPhone(employeeDTO.getPhone());
		
		return employeeRepository.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public String deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
		return "Employee deleted!";
	}
	
	public static EmployeeDTO toDTO(Employee employee) {

        return new EmployeeDTO(
            employee.getName(),
            employee.getDepartment(),
            employee.getPhone(),
            employee.getAddress()
        );
    }

}

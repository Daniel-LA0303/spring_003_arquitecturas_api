package com.mx.soap.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.soap.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}

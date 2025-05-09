package com.mx.soap.service.api.soap.utils;

import org.springframework.beans.BeanUtils;

import com.mx.soap.service.api.soap.entity.Employee;
import com.mx.soap.service.api.soap.xmlclases.EmployeeInfo;

public class CommonUtils {
	
	
	public static EmployeeInfo convertToEmployeeInfo(Employee employee) {
	    EmployeeInfo employeeInfo = new EmployeeInfo();
	    BeanUtils.copyProperties(employee, employeeInfo);
	    return employeeInfo;
	}

}

package com.mx.soap.client.api.soap.service;

import com.mx.soap.client.api.soap.model.AddEmployeeInput;
import com.mx.soap.client.api.soap.model.AddEmployeeOutput;
import com.mx.soap.client.api.soap.model.DeleteEmployeeInput;
import com.mx.soap.client.api.soap.model.DeleteEmployeeOutput;
import com.mx.soap.client.api.soap.model.GetAllEmployeesInput;
import com.mx.soap.client.api.soap.model.GetAllEmployeesOutput;
import com.mx.soap.client.api.soap.model.GetOneEmployeeInput;
import com.mx.soap.client.api.soap.model.GetOneEmployeeOutput;
import com.mx.soap.client.api.soap.model.UpdateEmployeeInput;
import com.mx.soap.client.api.soap.model.UpdateEmployeeOutput;

public interface SoapClientService {
	
	AddEmployeeOutput addEmployee(AddEmployeeInput addEmployeeInput);
	
	GetAllEmployeesOutput getAllEmployees(GetAllEmployeesInput getAllEmployeesInput);
	
	GetOneEmployeeOutput getEmployee(GetOneEmployeeInput getOneEmployeeInput);
	
	UpdateEmployeeOutput updateEmployee(UpdateEmployeeInput updateEmployeeInput);
	
	DeleteEmployeeOutput deleteEmployee(DeleteEmployeeInput deleteEmployeeInput);
	
}

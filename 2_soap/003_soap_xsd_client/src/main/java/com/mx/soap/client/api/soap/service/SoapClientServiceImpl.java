package com.mx.soap.client.api.soap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.soap.client.api.soap.client.SoapClient;
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
import com.mx.soap.client.api.soap.service.utils.AddEmployeeMappingUtils;
import com.mx.soap.client.api.soap.service.utils.DeleteEmployeeMappingUtils;
import com.mx.soap.client.api.soap.service.utils.GetAllEmployeesMappingUtils;
import com.mx.soap.client.api.soap.service.utils.GetOneEmployeeMappingUtils;
import com.mx.soap.client.api.soap.service.utils.UpdateEmployeeMappingUtils;
import com.mx.soap.client.api.soap.xmlclases.AddEmployeeRequest;
import com.mx.soap.client.api.soap.xmlclases.AddEmployeeResponse;
import com.mx.soap.client.api.soap.xmlclases.DeleteEmployeeRequest;
import com.mx.soap.client.api.soap.xmlclases.DeleteEmployeeResponse;
import com.mx.soap.client.api.soap.xmlclases.GetAllEmployeesRequest;
import com.mx.soap.client.api.soap.xmlclases.GetAllEmployeesResponse;
import com.mx.soap.client.api.soap.xmlclases.GetEmployeeByIdRequest;
import com.mx.soap.client.api.soap.xmlclases.GetEmployeeResponse;
import com.mx.soap.client.api.soap.xmlclases.UpdateEmployeeRequest;
import com.mx.soap.client.api.soap.xmlclases.UpdateEmployeeResponse;

@Service
public class SoapClientServiceImpl implements SoapClientService{
	
	@Autowired 
	private SoapClient soapClient;

	@Override
	public AddEmployeeOutput addEmployee(AddEmployeeInput addEmployeeInput) {
		
		AddEmployeeRequest request = AddEmployeeMappingUtils.buildRequest(addEmployeeInput);
		
        AddEmployeeResponse response = soapClient.addEmployee(request);
        
        AddEmployeeOutput output = AddEmployeeMappingUtils.buildOutput(response);
        
		return output;
	}

	@Override
	public GetAllEmployeesOutput getAllEmployees(GetAllEmployeesInput getAllEmployeesInput) {
		
		GetAllEmployeesRequest request = GetAllEmployeesMappingUtils.buildRequest(getAllEmployeesInput);
		
		GetAllEmployeesResponse response = soapClient.getAllEmployess(request);
		
		GetAllEmployeesOutput output = GetAllEmployeesMappingUtils.buildOutput(response);
		
		return output;
	}

	@Override
	public GetOneEmployeeOutput getEmployee(GetOneEmployeeInput getOneEmployeeInput) {
		
		GetEmployeeByIdRequest request = GetOneEmployeeMappingUtils.buildRequest(getOneEmployeeInput);
		
		GetEmployeeResponse response = soapClient.getOneEmployee(request);
		
		GetOneEmployeeOutput output = GetOneEmployeeMappingUtils.buildOutput(response);
		
		return output;
	}

	@Override
	public UpdateEmployeeOutput updateEmployee(UpdateEmployeeInput updateEmployeeInput ) {
		
		UpdateEmployeeRequest request = UpdateEmployeeMappingUtils.buildRequest(updateEmployeeInput);
		
		UpdateEmployeeResponse response = soapClient.updateEmployee(request);
		
		UpdateEmployeeOutput output = UpdateEmployeeMappingUtils.buildOutput(response);
		
		return output;
	}

	@Override
	public DeleteEmployeeOutput deleteEmployee(DeleteEmployeeInput deleteEmployeeInput) {
		
		DeleteEmployeeRequest request = DeleteEmployeeMappingUtils.buildRequest(deleteEmployeeInput);
		
		DeleteEmployeeResponse response = soapClient.deleteOneEmployee(request);
	
		DeleteEmployeeOutput output = DeleteEmployeeMappingUtils.buildOutput(response);
		
		
		return output;
	}

}

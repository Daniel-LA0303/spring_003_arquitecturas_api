package com.mx.soap.client.api.soap.service.utils;

import com.mx.soap.client.api.soap.model.AddEmployeeInput;
import com.mx.soap.client.api.soap.model.AddEmployeeOutput;
import com.mx.soap.client.api.soap.xmlclases.AddEmployeeRequest;
import com.mx.soap.client.api.soap.xmlclases.AddEmployeeResponse;

public class AddEmployeeMappingUtils {

	/**
	 * 
	 */
	public AddEmployeeMappingUtils() {
	}
	
	
	public static AddEmployeeOutput buildOutput(AddEmployeeResponse addEmployeeResponse) {
		
		AddEmployeeOutput response = DtoMapper.toAddEmployeeOutput(addEmployeeResponse);
		return response;
	}
	
	public static AddEmployeeRequest buildRequest(AddEmployeeInput addEmployeeInput) {
		
		AddEmployeeRequest request = DtoMapper.toAddEmployeeRequest(addEmployeeInput);
		
		return request;
	}
	
	

}

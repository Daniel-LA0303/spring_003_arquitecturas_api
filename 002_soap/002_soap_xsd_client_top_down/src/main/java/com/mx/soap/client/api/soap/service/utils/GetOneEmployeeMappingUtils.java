package com.mx.soap.client.api.soap.service.utils;

import com.mx.soap.client.api.soap.model.GetOneEmployeeInput;
import com.mx.soap.client.api.soap.model.GetOneEmployeeOutput;
import com.mx.soap.client.api.soap.xmlclases.GetEmployeeByIdRequest;
import com.mx.soap.client.api.soap.xmlclases.GetEmployeeResponse;

public class GetOneEmployeeMappingUtils {

	/**
	 * 
	 */
	public GetOneEmployeeMappingUtils() {
	}

	public static GetOneEmployeeOutput buildOutput(GetEmployeeResponse getEmployeeResponse) {
		
		GetOneEmployeeOutput response = DtoMapper.toGetOneEmployeeOutput(getEmployeeResponse);
		
		return response;
	}
	
	public static GetEmployeeByIdRequest buildRequest(GetOneEmployeeInput getOneEmployeeInput) {
		
		if(getOneEmployeeInput == null) {
	    	   return null;
	    }
	       
	    GetEmployeeByIdRequest request = new GetEmployeeByIdRequest();
	    request.setEmployeeId(getOneEmployeeInput.getId());

	    return request;
	}
	
}

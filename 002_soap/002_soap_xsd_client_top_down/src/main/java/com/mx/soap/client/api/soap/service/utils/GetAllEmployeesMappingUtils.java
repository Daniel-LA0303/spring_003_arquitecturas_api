package com.mx.soap.client.api.soap.service.utils;

import com.mx.soap.client.api.soap.model.GetAllEmployeesInput;
import com.mx.soap.client.api.soap.model.GetAllEmployeesOutput;
import com.mx.soap.client.api.soap.xmlclases.GetAllEmployeesRequest;
import com.mx.soap.client.api.soap.xmlclases.GetAllEmployeesResponse;

public class GetAllEmployeesMappingUtils {

	/**
	 * 
	 */
	public GetAllEmployeesMappingUtils() {
	}
	
	public static GetAllEmployeesOutput buildOutput(GetAllEmployeesResponse getAllEmployeesResponse) {
		
		GetAllEmployeesOutput response = DtoMapper.toGetAllEmployeesOutput(getAllEmployeesResponse);
		
		return response;
	}
	
	public static GetAllEmployeesRequest buildRequest(GetAllEmployeesInput getAllEmployeesInput) {
		
		GetAllEmployeesRequest request = new GetAllEmployeesRequest();
		
		return request;
	}

}

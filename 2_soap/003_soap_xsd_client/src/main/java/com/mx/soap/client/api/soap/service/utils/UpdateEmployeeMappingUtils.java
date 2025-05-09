package com.mx.soap.client.api.soap.service.utils;

import com.mx.soap.client.api.soap.model.StatusResponse;
import com.mx.soap.client.api.soap.model.UpdateEmployeeInput;
import com.mx.soap.client.api.soap.model.UpdateEmployeeOutput;
import com.mx.soap.client.api.soap.xmlclases.ServiceStatus;
import com.mx.soap.client.api.soap.xmlclases.UpdateEmployeeRequest;
import com.mx.soap.client.api.soap.xmlclases.UpdateEmployeeResponse;

public class UpdateEmployeeMappingUtils {
	
	public static UpdateEmployeeOutput buildOutput(UpdateEmployeeResponse updateEmployeeResponse) {
		
		
		if (updateEmployeeResponse == null) {
            return null;
        }
        
        
        StatusResponse statusResponse = new StatusResponse();
        ServiceStatus serviceStatus = updateEmployeeResponse.getServiceStatus();
        
        if (serviceStatus != null) {
            statusResponse.setStatus(serviceStatus.getStatus());
            statusResponse.setMessage(serviceStatus.getMessage());
        }
        
    	
    	return new UpdateEmployeeOutput(statusResponse);
	}
	
	public static UpdateEmployeeRequest buildRequest(UpdateEmployeeInput updateEmployeeInput) {
		
		UpdateEmployeeRequest request = DtoMapper.toUpdateEmployeeRequest(updateEmployeeInput);
		
		return request;
	}

}

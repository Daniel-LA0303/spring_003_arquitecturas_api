package com.mx.soap.client.api.soap.service.utils;

import com.mx.soap.client.api.soap.model.DeleteEmployeeInput;
import com.mx.soap.client.api.soap.model.DeleteEmployeeOutput;
import com.mx.soap.client.api.soap.model.StatusResponse;
import com.mx.soap.client.api.soap.xmlclases.DeleteEmployeeRequest;
import com.mx.soap.client.api.soap.xmlclases.DeleteEmployeeResponse;
import com.mx.soap.client.api.soap.xmlclases.ServiceStatus;

public class DeleteEmployeeMappingUtils {

	/**
	 * 
	 */
	public DeleteEmployeeMappingUtils() {
	}
	
	
	public static DeleteEmployeeOutput buildOutput(DeleteEmployeeResponse deleteEmployeeResponse) {
		
		if (deleteEmployeeResponse == null) {
            return null;
        }
        
        
        StatusResponse statusResponse = new StatusResponse();
        ServiceStatus serviceStatus = deleteEmployeeResponse.getServiceStatus();
        
        if (serviceStatus != null) {
            statusResponse.setStatus(serviceStatus.getStatus());
            statusResponse.setMessage(serviceStatus.getMessage());
        }
        
    	
    	return new DeleteEmployeeOutput(statusResponse);
	}
	
	public static DeleteEmployeeRequest buildRequest(DeleteEmployeeInput deleteEmployeeInput) {
		
	       if(deleteEmployeeInput == null) {
	    	   return null;
	       }
	       
	       DeleteEmployeeRequest request = new DeleteEmployeeRequest();
	       request.setEmployeeId(deleteEmployeeInput.getId());
	        
	    	
	    	return request;
	}
	
	
}

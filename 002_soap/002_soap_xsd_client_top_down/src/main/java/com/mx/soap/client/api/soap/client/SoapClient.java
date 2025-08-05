package com.mx.soap.client.api.soap.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

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

public class SoapClient extends WebServiceGatewaySupport{
	
	/**
     * Método que se encarga de agregar un empleado
     *
     * @param employeeInfo
     * @return AddEmployeeResponse
     */
    public AddEmployeeResponse addEmployee(AddEmployeeRequest employeeInfo) {
        
        SoapActionCallback soapActionCallback = new SoapActionCallback("http://soap.api.service.soap.mx.com/addEmployeeRequest");

        AddEmployeeResponse addEmployeeResponse = (AddEmployeeResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/employee/api", employeeInfo, soapActionCallback);

        return addEmployeeResponse;
    }
    
    public GetAllEmployeesResponse getAllEmployess(GetAllEmployeesRequest getAllEmployees) {

    	
        SoapActionCallback soapActionCallback = new SoapActionCallback("http://soap.api.service.soap.mx.com/getAllEmployeesRequest");

        GetAllEmployeesResponse getEmployeesResponse = (GetAllEmployeesResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/employee/api", getAllEmployees, soapActionCallback);

        return getEmployeesResponse;
    }
	
    public GetEmployeeResponse getOneEmployee(GetEmployeeByIdRequest getEmployeeByIdRequest) {
	
        SoapActionCallback soapActionCallback = new SoapActionCallback("http://soap.api.service.soap.mx.com/getEmployeeByIdRequest");

        GetEmployeeResponse getEmployeeResponse = (GetEmployeeResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/employee/api", getEmployeeByIdRequest, soapActionCallback);

        return getEmployeeResponse;
    }
    
    public UpdateEmployeeResponse updateEmployee(UpdateEmployeeRequest updateEmployeeRequest) {

    	
        SoapActionCallback soapActionCallback = new SoapActionCallback("http://soap.api.service.soap.mx.com/updateEmployeeRequest");

        UpdateEmployeeResponse updateEmployeeResponse = (UpdateEmployeeResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/employee/api", updateEmployeeRequest, soapActionCallback);

        return updateEmployeeResponse;
    }
    
    
    public DeleteEmployeeResponse deleteOneEmployee(DeleteEmployeeRequest deleteEmployeeRequest) {

    	
        SoapActionCallback soapActionCallback = new SoapActionCallback("http://soap.api.service.soap.mx.com/getAllEmployeesRequest");

        DeleteEmployeeResponse deleteEmployeeResponse = (DeleteEmployeeResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/employee/api", deleteEmployeeRequest, soapActionCallback);

        return deleteEmployeeResponse;
    }
	

}

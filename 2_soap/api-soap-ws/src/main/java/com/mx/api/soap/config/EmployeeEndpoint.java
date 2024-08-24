package com.mx.api.soap.config;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.mx.api.soap.entity.Employee;
import com.mx.api.soap.interfaces.AddEmployeeRequest;
import com.mx.api.soap.interfaces.AddEmployeeResponse;
import com.mx.api.soap.interfaces.DeleteEmployeeRequest;
import com.mx.api.soap.interfaces.DeleteEmployeeResponse;
import com.mx.api.soap.interfaces.EmployeeInfo;
import com.mx.api.soap.interfaces.GetAllEmployeesResponse;
import com.mx.api.soap.interfaces.GetEmployeeByIdRequest;
import com.mx.api.soap.interfaces.GetEmployeeResponse;
import com.mx.api.soap.interfaces.ServiceStatus;
import com.mx.api.soap.interfaces.UpdateEmployeeRequest;
import com.mx.api.soap.interfaces.UpdateEmployeeResponse;
import com.mx.api.soap.service.EmployeeService;

@Endpoint
public class EmployeeEndpoint {

	private static final String NAMESPACE_URI = "http://interfaces.soap.api.mx.com";

	@Autowired
	private EmployeeService employeeService;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllEmployeesRequest")
	@ResponsePayload
	public GetAllEmployeesResponse getAllEmployees() {
	    GetAllEmployeesResponse response = new GetAllEmployeesResponse();
	    List<Employee> employees = employeeService.getAllEmployees(); 
	    
	    List<EmployeeInfo> employeeInfoList = employees.stream()
	        .map(employee -> {
	            EmployeeInfo info = new EmployeeInfo();
	            BeanUtils.copyProperties(employee, info);
	            return info;
	        })
	        .collect(Collectors.toList());

	    response.setEmployeeInfoList(employeeInfoList);
	    return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addEmployeeRequest")
	@ResponsePayload
	public AddEmployeeResponse addEmployee(@RequestPayload AddEmployeeRequest request) {
		AddEmployeeResponse response = new AddEmployeeResponse();
		ServiceStatus serviceStatus = new ServiceStatus();

		Employee employee = new Employee();
		BeanUtils.copyProperties(request.getEmployeeInfo(), employee);
		employeeService.addEmployee(employee);
		serviceStatus.setStatus("SUCCESS");
		serviceStatus.setMessage("Content Added Successfully");
		response.setServiceStatus(serviceStatus);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteEmployeeRequest")
	@ResponsePayload
	public DeleteEmployeeResponse deleteEmployee(@RequestPayload DeleteEmployeeRequest request) {
		employeeService.deleteEmployee(request.getEmployeeId());
		ServiceStatus serviceStatus = new ServiceStatus();

		serviceStatus.setStatus("SUCCESS");
		serviceStatus.setMessage("Content Deleted Successfully");
		DeleteEmployeeResponse response = new DeleteEmployeeResponse();
		response.setServiceStatus(serviceStatus);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEmployeeByIdRequest")
	@ResponsePayload
	public GetEmployeeResponse getEmployee(@RequestPayload GetEmployeeByIdRequest request) {
		GetEmployeeResponse response = new GetEmployeeResponse();
		EmployeeInfo employeeInfo = new EmployeeInfo();
		BeanUtils.copyProperties(employeeService.getEmployeeById(request.getEmployeeId()), employeeInfo);
		response.setEmployeeInfo(employeeInfo);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateEmployeeRequest")
	@ResponsePayload
	public UpdateEmployeeResponse updateEmployee(@RequestPayload UpdateEmployeeRequest request) {
		Employee employee = new Employee();
		BeanUtils.copyProperties(request.getEmployeeInfo(), employee);
		employeeService.updateEmployee(employee);
		ServiceStatus serviceStatus = new ServiceStatus();
		serviceStatus.setStatus("SUCCESS");
		serviceStatus.setMessage("Content Updated Successfully");
		UpdateEmployeeResponse response = new UpdateEmployeeResponse();
		response.setServiceStatus(serviceStatus);
		return response;
	}

}
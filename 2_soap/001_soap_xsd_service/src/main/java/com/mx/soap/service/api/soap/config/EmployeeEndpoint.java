package com.mx.soap.service.api.soap.config;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.mx.soap.service.api.soap.entity.Employee;
import com.mx.soap.service.api.soap.enums.ServiceStatusEnum;
import com.mx.soap.service.api.soap.service.EmployeeService;
import com.mx.soap.service.api.soap.utils.CommonUtils;
import com.mx.soap.service.api.soap.xmlclases.AddEmployeeRequest;
import com.mx.soap.service.api.soap.xmlclases.AddEmployeeResponse;
import com.mx.soap.service.api.soap.xmlclases.DeleteEmployeeRequest;
import com.mx.soap.service.api.soap.xmlclases.DeleteEmployeeResponse;
import com.mx.soap.service.api.soap.xmlclases.EmployeeInfo;
import com.mx.soap.service.api.soap.xmlclases.EmployeeInfoList;
import com.mx.soap.service.api.soap.xmlclases.GetAllEmployeesRequest;
import com.mx.soap.service.api.soap.xmlclases.GetAllEmployeesResponse;
import com.mx.soap.service.api.soap.xmlclases.GetEmployeeByIdRequest;
import com.mx.soap.service.api.soap.xmlclases.GetEmployeeResponse;
import com.mx.soap.service.api.soap.xmlclases.ServiceStatus;
import com.mx.soap.service.api.soap.xmlclases.UpdateEmployeeRequest;
import com.mx.soap.service.api.soap.xmlclases.UpdateEmployeeResponse;


@Endpoint
public class EmployeeEndpoint {

	private static final String NAMESPACE_URI = "http://soap.api.service.soap.mx.com";

	@Autowired
	private EmployeeService employeeService;
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllEmployeesRequest")
	@ResponsePayload
	public GetAllEmployeesResponse getAllEmployees(@RequestPayload GetAllEmployeesRequest request) {
	    GetAllEmployeesResponse response = new GetAllEmployeesResponse();
	    ServiceStatus serviceStatus = new ServiceStatus();
	    EmployeeInfoList employeeInfoListWrapper = new EmployeeInfoList();

	    try {
	        List<Employee> employees = employeeService.getAllEmployees();

	        List<EmployeeInfo> employeeInfoList = employees.stream()
	            .map(employee -> {
	                EmployeeInfo info = new EmployeeInfo();
	                BeanUtils.copyProperties(employee, info);
	                return info;
	            })
	            .collect(Collectors.toList());

	        employeeInfoListWrapper.getEmployeeInfo().addAll(employeeInfoList);

	        serviceStatus.setStatus(ServiceStatusEnum.SUCCESS.getStatus());
	        serviceStatus.setMessage("Employees retrieved successfully");
	        
	        response.setEmployeeList(employeeInfoListWrapper);
	    } catch (Exception e) {
	        serviceStatus.setStatus(ServiceStatusEnum.ERROR.getStatus());
	        serviceStatus.setMessage("An error occurred: " + e.getMessage());

	        response.setEmployeeList(employeeInfoListWrapper);
	    }

	    response.setServiceStatus(serviceStatus);
	    return response;
	}


	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addEmployeeRequest")
	@ResponsePayload
	public AddEmployeeResponse addEmployee(@RequestPayload AddEmployeeRequest request) {
	    AddEmployeeResponse response = new AddEmployeeResponse();
	    ServiceStatus serviceStatus = new ServiceStatus();

	    try {
	        Employee employee = new Employee();
	        BeanUtils.copyProperties(request.getEmployeeInfo(), employee);
	        
	        Employee savedEmployee = employeeService.addEmployee(employee);
	        
	        serviceStatus.setStatus(ServiceStatusEnum.SUCCESS.getStatus());
	        serviceStatus.setMessage("Employee added successfully");
	        
	        response.setEmployeeInfo(CommonUtils.convertToEmployeeInfo(savedEmployee));
	    } catch (Exception e) {
	        serviceStatus.setStatus(ServiceStatusEnum.ERROR.getStatus());
	        serviceStatus.setMessage("An error occurred: " + e.getMessage());
	    }


	    response.setServiceStatus(serviceStatus);
	    return response;
	    
	}
	

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteEmployeeRequest")
	@ResponsePayload
	public DeleteEmployeeResponse deleteEmployee(@RequestPayload DeleteEmployeeRequest request) {
	    DeleteEmployeeResponse response = new DeleteEmployeeResponse();
	    ServiceStatus serviceStatus = new ServiceStatus();
	    
	    try {
	        Employee existingEmployee = employeeService.getEmployeeById(request.getEmployeeId());

	        if (existingEmployee != null) {
	            employeeService.deleteEmployee(request.getEmployeeId());

	            serviceStatus.setStatus(ServiceStatusEnum.SUCCESS.getStatus());
	            serviceStatus.setMessage("Employee deleted successfully");
	        } else {
	            serviceStatus.setStatus(ServiceStatusEnum.NOT_FOUND.getStatus());
	            serviceStatus.setMessage("Employee with ID " + request.getEmployeeId() + " not found");
	        }
	    } catch (Exception e) {
	        serviceStatus.setStatus(ServiceStatusEnum.ERROR.getStatus());
	        serviceStatus.setMessage("An error occurred: " + e.getMessage());
	    }
	    
	    response.setServiceStatus(serviceStatus);
	    return response;
	}



	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEmployeeByIdRequest")
	@ResponsePayload
	public GetEmployeeResponse getEmployee(@RequestPayload GetEmployeeByIdRequest request) {
	    GetEmployeeResponse response = new GetEmployeeResponse();
	    ServiceStatus serviceStatus = new ServiceStatus();
	    
	    try {

	        Employee employee = employeeService.getEmployeeById(request.getEmployeeId());

	        if (employee == null) {
	            serviceStatus.setStatus(ServiceStatusEnum.NOT_FOUND.getStatus());
	            serviceStatus.setMessage("Employee not found");
	            response.setEmployeeInfo(null);
	        } else {

	            EmployeeInfo employeeInfo = new EmployeeInfo();
	            BeanUtils.copyProperties(employee, employeeInfo);

	            serviceStatus.setStatus(ServiceStatusEnum.SUCCESS.getStatus());
	            serviceStatus.setMessage("Employee retrieved successfully");
	            response.setEmployeeInfo(employeeInfo);
	        }
	    } catch (Exception e) {
	        serviceStatus.setStatus(ServiceStatusEnum.ERROR.getStatus());
	        serviceStatus.setMessage("An error occurred: " + e.getMessage());
	        response.setEmployeeInfo(null);
	    }

	    response.setServiceStatus(serviceStatus);
	    return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateEmployeeRequest")
	@ResponsePayload
	public UpdateEmployeeResponse updateEmployee(@RequestPayload UpdateEmployeeRequest request) {
	    UpdateEmployeeResponse response = new UpdateEmployeeResponse();
	    ServiceStatus serviceStatus = new ServiceStatus();
	    
	    try {
	  
	        Employee existingEmployee = employeeService.getEmployeeById(request.getEmployeeInfo().getEmployeeId());

	        if (existingEmployee != null) {
	            BeanUtils.copyProperties(request.getEmployeeInfo(), existingEmployee);

	            employeeService.updateEmployee(existingEmployee);

	            serviceStatus.setStatus(ServiceStatusEnum.SUCCESS.getStatus());
	            serviceStatus.setMessage("Employee updated successfully");
	        } else {
	            serviceStatus.setStatus(ServiceStatusEnum.NOT_FOUND.getStatus());
	            serviceStatus.setMessage("Employee with ID " + request.getEmployeeInfo().getEmployeeId() + " not found");
	        }
	    } catch (Exception e) {
	        serviceStatus.setStatus(ServiceStatusEnum.ERROR.getStatus());
	        serviceStatus.setMessage("An error occurred: " + e.getMessage());
	    }
	    
	    response.setServiceStatus(serviceStatus);
	    return response;
	}



}
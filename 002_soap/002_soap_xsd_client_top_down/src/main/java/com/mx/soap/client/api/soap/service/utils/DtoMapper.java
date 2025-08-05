package com.mx.soap.client.api.soap.service.utils;

import java.util.ArrayList;
import java.util.List;

import com.mx.soap.client.api.soap.dto.EmployeeAddResponseDTO;
import com.mx.soap.client.api.soap.dto.EmployeeAllInfoDTO;
import com.mx.soap.client.api.soap.dto.EmployeeInfoDTO;
import com.mx.soap.client.api.soap.dto.EmployeeUpdateInfoDTO;
import com.mx.soap.client.api.soap.model.AddEmployeeInput;
import com.mx.soap.client.api.soap.model.AddEmployeeOutput;
import com.mx.soap.client.api.soap.model.GetAllEmployeesOutput;
import com.mx.soap.client.api.soap.model.GetOneEmployeeOutput;
import com.mx.soap.client.api.soap.model.StatusResponse;
import com.mx.soap.client.api.soap.model.UpdateEmployeeInput;
import com.mx.soap.client.api.soap.xmlclases.AddEmployeeRequest;
import com.mx.soap.client.api.soap.xmlclases.AddEmployeeResponse;
import com.mx.soap.client.api.soap.xmlclases.EmployeeInfo;
import com.mx.soap.client.api.soap.xmlclases.EmployeeInfoForAdd;
import com.mx.soap.client.api.soap.xmlclases.EmployeeInfoList;
import com.mx.soap.client.api.soap.xmlclases.GetAllEmployeesResponse;
import com.mx.soap.client.api.soap.xmlclases.GetEmployeeResponse;
import com.mx.soap.client.api.soap.xmlclases.ServiceStatus;
import com.mx.soap.client.api.soap.xmlclases.UpdateEmployeeRequest;

public class DtoMapper {

    /**
     * Converts AddEmployeeResponse to AddEmployeeOutput.
     *
     * @param addEmployeeResponse the AddEmployeeResponse to convert
     * @return the corresponding AddEmployeeOutput
     */
    public static AddEmployeeOutput toAddEmployeeOutput(AddEmployeeResponse addEmployeeResponse) {
        if (addEmployeeResponse == null) {
            return null;
        }

        EmployeeAddResponseDTO employeeDto = new EmployeeAddResponseDTO();
        EmployeeInfo employeeInfo = addEmployeeResponse.getEmployeeInfo();

        if (employeeInfo != null) {
            employeeDto.setEmployeeId(employeeInfo.getEmployeeId());
            employeeDto.setName(employeeInfo.getName());
            employeeDto.setDepartment(employeeInfo.getDepartment());
            employeeDto.setPhone(employeeInfo.getPhone());
            employeeDto.setAddress(employeeInfo.getAddress());
        }

        StatusResponse statusResponse = new StatusResponse();
        ServiceStatus serviceStatus = addEmployeeResponse.getServiceStatus();

        if (serviceStatus != null) {
            statusResponse.setStatus(serviceStatus.getStatus());
            statusResponse.setMessage(serviceStatus.getMessage());
        }

        return new AddEmployeeOutput(employeeDto, statusResponse);
    }
    
    /**
     * 
     * @param getAllEmployeesResponse
     * @return
     */
    public static GetAllEmployeesOutput toGetAllEmployeesOutput(GetAllEmployeesResponse getAllEmployeesResponse) {
    	if (getAllEmployeesResponse == null) {
            return null;
        }

        ServiceStatus serviceStatus = getAllEmployeesResponse.getServiceStatus();
        StatusResponse statusResponse = new StatusResponse();

        if (serviceStatus != null) {
            statusResponse.setStatus(serviceStatus.getStatus());
            statusResponse.setMessage(serviceStatus.getMessage());
        }

        EmployeeInfoList employeeInfoList = getAllEmployeesResponse.getEmployeeList();
        List<EmployeeAllInfoDTO> employeeDtoList = new ArrayList<>();

        if (employeeInfoList != null && employeeInfoList.getEmployeeInfo() != null) {
            for (EmployeeInfo employeeInfo : employeeInfoList.getEmployeeInfo()) {
                EmployeeAllInfoDTO dto = new EmployeeAllInfoDTO();
                dto.setEmployeeId(employeeInfo.getEmployeeId());
                dto.setName(employeeInfo.getName());
                dto.setDepartment(employeeInfo.getDepartment());
                dto.setPhone(employeeInfo.getPhone());
                dto.setAddress(employeeInfo.getAddress());
                employeeDtoList.add(dto);
            }
        }

        return new GetAllEmployeesOutput(statusResponse, employeeDtoList);
    }
    
    /**
     * 
     * @param getEmployeeResponse
     * @return
     */
    public static GetOneEmployeeOutput toGetOneEmployeeOutput(GetEmployeeResponse getEmployeeResponse) {
    	
        if (getEmployeeResponse == null) {
            return null;
        }
        
        EmployeeAllInfoDTO employeeAllInfoDTO = new EmployeeAllInfoDTO();
    	EmployeeInfo employeeInfo = getEmployeeResponse.getEmployeeInfo();
    	
    	if(employeeInfo != null) {
    		employeeAllInfoDTO.setAddress(employeeInfo.getAddress());
    		employeeAllInfoDTO.setDepartment(employeeInfo.getDepartment());
    		employeeAllInfoDTO.setEmployeeId(employeeInfo.getEmployeeId());
    		employeeAllInfoDTO.setName(employeeInfo.getName());
    		employeeAllInfoDTO.setPhone(employeeInfo.getPhone());
    		
    	}
    	
    	StatusResponse statusResponse = new StatusResponse();
        ServiceStatus serviceStatus = getEmployeeResponse.getServiceStatus();

        if (serviceStatus != null) {
            statusResponse.setStatus(serviceStatus.getStatus());
            statusResponse.setMessage(serviceStatus.getMessage());
        }

        return new GetOneEmployeeOutput(employeeAllInfoDTO, statusResponse);
    }
    
    
    /**
     * Converts AddEmployeeInput to AddEmployeeRequest.
     *
     * @param addEmployeeInput the AddEmployeeInput to convert
     * @return the corresponding AddEmployeeRequest
     */
    public static AddEmployeeRequest toAddEmployeeRequest(AddEmployeeInput addEmployeeInput) {
        if (addEmployeeInput == null) {
            return null;
        }

        EmployeeInfoDTO employeeInfoDTO = addEmployeeInput.getEmployeeAddInfoDTO();
        EmployeeInfoForAdd employeeInfoForAdd = new EmployeeInfoForAdd();

        if (employeeInfoDTO != null) {
            employeeInfoForAdd.setName(employeeInfoDTO.getName());
            employeeInfoForAdd.setDepartment(employeeInfoDTO.getDepartment());
            employeeInfoForAdd.setPhone(employeeInfoDTO.getPhone());
            employeeInfoForAdd.setAddress(employeeInfoDTO.getAddress());
        }

        AddEmployeeRequest addEmployeeRequest = new AddEmployeeRequest();
        addEmployeeRequest.setEmployeeInfo(employeeInfoForAdd);

        return addEmployeeRequest;
    }
    
    /**
     * 
     * @param updateEmployeeInput
     * @return
     */
    public static UpdateEmployeeRequest toUpdateEmployeeRequest(UpdateEmployeeInput updateEmployeeInput) {
    	
        if (updateEmployeeInput == null) {
            return null;
        }
    	
        EmployeeUpdateInfoDTO employeeUpdateInfoDTO =  updateEmployeeInput.getEmployeeUpdateInfoDTO();
        EmployeeInfo employeeInfo = new EmployeeInfo();
        
        if (employeeUpdateInfoDTO != null) {
        	employeeInfo.setEmployeeId(employeeUpdateInfoDTO.getEmployeeId());
        	employeeInfo.setName(employeeUpdateInfoDTO.getName());
        	employeeInfo.setDepartment(employeeUpdateInfoDTO.getDepartment());
        	employeeInfo.setPhone(employeeUpdateInfoDTO.getPhone());
        	employeeInfo.setAddress(employeeUpdateInfoDTO.getAddress());
        }
      
        UpdateEmployeeRequest updateEmployeeRequest = new UpdateEmployeeRequest();
        updateEmployeeRequest.setEmployeeInfo(employeeInfo);
        
    	
    	return updateEmployeeRequest;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}

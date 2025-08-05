package com.mx.soap.client.api.soap.model;

import java.util.List;

import com.mx.soap.client.api.soap.dto.EmployeeAllInfoDTO;

public class GetAllEmployeesOutput {
	
	private StatusResponse statusResponse;
	
	private List<EmployeeAllInfoDTO> employees;
	

	/**
	 * 
	 */
	public GetAllEmployeesOutput() {
	}

	/**
	 * @param statusResponse
	 * @param employeeUpdateInfoDTO
	 */
	public GetAllEmployeesOutput(StatusResponse statusResponse, List<EmployeeAllInfoDTO> employess) {
		this.statusResponse = statusResponse;
		this.employees = employess;
	}

	/**
	 * @return the statusResponse
	 */
	public StatusResponse getStatusResponse() {
		return statusResponse;
	}

	/**
	 * @param statusResponse the statusResponse to set
	 */
	public void setStatusResponse(StatusResponse statusResponse) {
		this.statusResponse = statusResponse;
	}

	/**
	 * @return the employeeUpdateInfoDTO
	 */
	public List<EmployeeAllInfoDTO> getEmployees() {
		return employees;
	}

	/**
	 * @param employeeUpdateInfoDTO the employeeUpdateInfoDTO to set
	 */
	public void setEmployees(List<EmployeeAllInfoDTO> employees) {
		this.employees = employees;
	}

}

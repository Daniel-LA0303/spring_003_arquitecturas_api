package com.mx.soap.client.api.soap.model;

import com.mx.soap.client.api.soap.dto.EmployeeAddResponseDTO;

public class AddEmployeeOutput {
	
	/**
	 * employe
	 */
	private EmployeeAddResponseDTO employee;
	
	/**
	 * status response
	 */
	private StatusResponse statusResponse;
	
	/**
	 * 
	 */
	public AddEmployeeOutput() {
	}

	/**
	 * @param employee
	 * @param statusResponse
	 */
	public AddEmployeeOutput(EmployeeAddResponseDTO employee, StatusResponse statusResponse) {
		this.employee = employee;
		this.statusResponse = statusResponse;
	}
	

	/**
	 * @return the employee
	 */
	public EmployeeAddResponseDTO getEmployee() {
		return employee;
	}


	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(EmployeeAddResponseDTO employee) {
		this.employee = employee;
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


}

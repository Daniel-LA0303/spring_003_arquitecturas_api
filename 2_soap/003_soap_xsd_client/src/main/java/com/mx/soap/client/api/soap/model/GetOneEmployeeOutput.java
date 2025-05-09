package com.mx.soap.client.api.soap.model;

import com.mx.soap.client.api.soap.dto.EmployeeAllInfoDTO;

public class GetOneEmployeeOutput {
	
	/**
	 * employe
	 */
	private EmployeeAllInfoDTO employee;
	
	/**
	 * status response
	 */
	private StatusResponse statusResponse;

	/**
	 * 
	 */
	public GetOneEmployeeOutput() {
	}

	/**
	 * @param employee
	 * @param statusResponse
	 */
	public GetOneEmployeeOutput(EmployeeAllInfoDTO employee, StatusResponse statusResponse) {
		this.employee = employee;
		this.statusResponse = statusResponse;
	}

	/**
	 * @return the employee
	 */
	public EmployeeAllInfoDTO getEmployee() {
		return employee;
	}

	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(EmployeeAllInfoDTO employee) {
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

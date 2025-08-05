package com.mx.soap.client.api.soap.model;

import com.mx.soap.client.api.soap.dto.EmployeeUpdateInfoDTO;

public class UpdateEmployeeInput {
	
	/**
	 * employee update info
	 */
	private EmployeeUpdateInfoDTO employeeUpdateInfoDTO;

	/**
	 * 
	 */
	public UpdateEmployeeInput() {
	}

	/**
	 * @param employeeUpdateInfoDTO
	 */
	public UpdateEmployeeInput(EmployeeUpdateInfoDTO employeeUpdateInfoDTO) {
		this.employeeUpdateInfoDTO = employeeUpdateInfoDTO;
	}

	/**
	 * @return the employeeUpdateInfoDTO
	 */
	public EmployeeUpdateInfoDTO getEmployeeUpdateInfoDTO() {
		return employeeUpdateInfoDTO;
	}

	/**
	 * @param employeeUpdateInfoDTO the employeeUpdateInfoDTO to set
	 */
	public void setEmployeeUpdateInfoDTO(EmployeeUpdateInfoDTO employeeUpdateInfoDTO) {
		this.employeeUpdateInfoDTO = employeeUpdateInfoDTO;
	}
	
}

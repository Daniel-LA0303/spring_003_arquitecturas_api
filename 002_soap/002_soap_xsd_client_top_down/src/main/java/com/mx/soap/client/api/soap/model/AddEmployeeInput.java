package com.mx.soap.client.api.soap.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mx.soap.client.api.soap.dto.EmployeeInfoDTO;

public class AddEmployeeInput {
	
	@JsonProperty("employeeInfoDTO")
	private EmployeeInfoDTO employeeInfoDTO;

	@Override
	public String toString() {
		return "AddEmployeeInput [employeeInfoDTO=" + employeeInfoDTO + "]";
	}

	/**
	 * 
	 */
	public AddEmployeeInput() {
	}

	/**
	 * @param employeeAddInfoDTO
	 */
	public AddEmployeeInput(EmployeeInfoDTO employeeInfoDTO) {
		this.employeeInfoDTO = employeeInfoDTO;
	}

	/**
	 * @return the employeeAddInfoDTO
	 */
	public EmployeeInfoDTO getEmployeeAddInfoDTO() {
		return employeeInfoDTO;
	}

	/**
	 * @param employeeAddInfoDTO the employeeAddInfoDTO to set
	 */
	public void setEmployeeAddInfoDTO(EmployeeInfoDTO employeeInfoDTO) {
		this.employeeInfoDTO = employeeInfoDTO;
	}
	
	
	
}

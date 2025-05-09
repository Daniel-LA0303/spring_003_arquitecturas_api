package com.mx.soap.client.api.soap.model;

public class UpdateEmployeeOutput {
	
	/**
	 * status response
	 */
	private StatusResponse statusResponse;
	
	/**
	 * 
	 */
	public UpdateEmployeeOutput() {
	}

	/**
	 * @param statusResponse
	 */
	public UpdateEmployeeOutput(StatusResponse statusResponse) {
		this.statusResponse = statusResponse;
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

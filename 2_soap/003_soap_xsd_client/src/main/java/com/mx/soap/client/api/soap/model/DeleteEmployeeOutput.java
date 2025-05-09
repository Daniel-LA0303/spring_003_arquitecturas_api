package com.mx.soap.client.api.soap.model;

public class DeleteEmployeeOutput {
	
	/**
	 * status response
	 */
	private StatusResponse statusResponse;

	/**
	 * 
	 */
	public DeleteEmployeeOutput() {
	}

	/**
	 * @param statusResponse
	 */
	public DeleteEmployeeOutput(StatusResponse statusResponse) {
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

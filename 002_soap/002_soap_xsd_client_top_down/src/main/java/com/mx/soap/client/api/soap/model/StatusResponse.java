package com.mx.soap.client.api.soap.model;

public class StatusResponse {
	
	private String status;
	
	private String message;
	
	/**
	 * 
	 */
	public StatusResponse() {
	}

	/**
	 * @param status
	 * @param message
	 */
	public StatusResponse(String status, String message) {
		this.status = status;
		this.message = message;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}

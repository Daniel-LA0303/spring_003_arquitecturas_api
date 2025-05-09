package com.mx.soap.client.api.soap.model;

public class GetOneEmployeeInput {
	
	/**
	 * id
	 */
	private long id;

	/**
	 * 
	 */
	public GetOneEmployeeInput() {
		super();
	}

	/**
	 * @param id
	 */
	public GetOneEmployeeInput(long id) {
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	

}

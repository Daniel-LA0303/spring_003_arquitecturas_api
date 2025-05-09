package com.mx.soap.client.api.soap.model;

public class DeleteEmployeeInput {
	
	/**
	 * id
	 */
	private long id;

	/**
	 * 
	 */
	public DeleteEmployeeInput() {
		super();
	}

	/**
	 * @param id
	 */
	public DeleteEmployeeInput(long id) {
		super();
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

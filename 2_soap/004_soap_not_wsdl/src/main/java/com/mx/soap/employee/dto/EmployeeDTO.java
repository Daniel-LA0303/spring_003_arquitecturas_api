package com.mx.soap.employee.dto;

public class EmployeeDTO {
	
	private String name;

	private String department;

	private String phone;

	private String address;
	
	public EmployeeDTO() {
	}

	public EmployeeDTO(String name, String department, String phone, String address) {
		this.name = name;
		this.department = department;
		this.phone = phone;
		this.address = address;
	}

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getDepartment() {
		return department;
	}



	public void setDepartment(String department) {
		this.department = department;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}

}

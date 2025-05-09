package com.mx.api.soap.interfaces;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for employeeInfo complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="employeeInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="employeeId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="department" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="phone" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="address" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "employeeInfo", propOrder = { 
		"employeeId",
		"name", 
		"department", 
		"phone", 
		"address" })
public class EmployeeInfo {

	protected long employeeId;

	/**
	 * name
	 */
	@XmlElement(required = true)
	protected String name;

	/**
	 * department
	 */
	@XmlElement(required = true)
	protected String department;

	/**
	 * phone
	 */
	@XmlElement(required = true)
	protected String phone;

	/**
	 * address
	 */
	@XmlElement(required = true)
	protected String address;

	/**
	 * return value of the propertie address
	 *
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * return value of the propertie department
	 *
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * return value of the propertie employeeId
	 *
	 * @return the employeeId
	 */
	public long getEmployeeId() {
		return employeeId;
	}

	/**
	 * return value of the propertie name
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * return value of the propertie phone
	 *
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * set value of the propertie address
	 *
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * set value of the propertie department
	 *
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * set value of the propertie employeeId
	 *
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * set value of the propertie name
	 *
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * set value of the propertie phone
	 *
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

}

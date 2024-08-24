package com.mx.api.soap.interfaces;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="serviceStatus" type="{http://interfaces.soap.springboot.vkakarla.com}serviceStatus"/>
 *         &lt;element name="employeeInfo" type="{http://interfaces.soap.springboot.vkakarla.com}employeeInfo"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "serviceStatus", "employeeInfo" })
@XmlRootElement(name = "addEmployeeResponse")
public class AddEmployeeResponse {

	/**
	 * ServiceStatus
	 */
	@XmlElement(required = true)
	protected ServiceStatus serviceStatus;

	/*
	 * EmployeeInfo
	 */
	@XmlElement(required = true)
	protected EmployeeInfo employeeInfo;

	/**
	 * return value of the propertie employeeInfo
	 *
	 * @return the employeeInfo
	 */
	public EmployeeInfo getEmployeeInfo() {
		return employeeInfo;
	}

	/**
	 * return value of the propertie serviceStatus
	 *
	 * @return the serviceStatus
	 */
	public ServiceStatus getServiceStatus() {
		return serviceStatus;
	}

	/**
	 * set value of the propertie employeeInfo
	 *
	 * @param employeeInfo the employeeInfo to set
	 */
	public void setEmployeeInfo(EmployeeInfo employeeInfo) {
		this.employeeInfo = employeeInfo;
	}

	/**
	 * set value of the propertie serviceStatus
	 *
	 * @param serviceStatus the serviceStatus to set
	 */
	public void setServiceStatus(ServiceStatus serviceStatus) {
		this.serviceStatus = serviceStatus;
	}

}

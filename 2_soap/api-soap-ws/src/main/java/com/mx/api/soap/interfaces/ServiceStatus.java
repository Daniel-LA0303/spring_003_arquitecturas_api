package com.mx.api.soap.interfaces;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for serviceStatus complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType name="serviceStatus">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "serviceStatus", propOrder = { "status", "message" })
public class ServiceStatus {

	/**
	 * status
	 */
	@XmlElement(required = true)
	protected String status;

	/**
	 * message
	 */
	@XmlElement(required = true)
	protected String message;

	/**
	 * return value of the propertie message
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * return value of the propertie status
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * set value of the propertie message
	 *
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * set value of the propertie status
	 *
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

}

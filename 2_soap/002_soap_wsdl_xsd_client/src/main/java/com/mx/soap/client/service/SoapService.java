package com.mx.soap.client.service;

import com.mx.soap.client.xmlclases.AddResponse;
import com.mx.soap.client.xmlclases.DivideResponse;
import com.mx.soap.client.xmlclases.MultiplyResponse;
import com.mx.soap.client.xmlclases.SubtractResponse;

public interface SoapService {
	
	public AddResponse addNumbers(int numberA, int numberB);
	
	public SubtractResponse subtractNumbers(int numberA, int numberB);
	
	public MultiplyResponse multiplyNumbers(int numberA, int numberB);
	
	public DivideResponse divideNumbers(int numberA, int numberB);

}

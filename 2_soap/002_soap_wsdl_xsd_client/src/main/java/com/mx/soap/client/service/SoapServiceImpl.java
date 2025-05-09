package com.mx.soap.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.soap.client.client.SoapClient;
import com.mx.soap.client.xmlclases.AddResponse;
import com.mx.soap.client.xmlclases.DivideResponse;
import com.mx.soap.client.xmlclases.MultiplyResponse;
import com.mx.soap.client.xmlclases.SubtractResponse;

@Service
public class SoapServiceImpl implements SoapService{
	
    @Autowired
    private SoapClient soapClient;

	@Override
	public AddResponse addNumbers(int numberA, int numberB) {
		AddResponse addResponse = soapClient.getAddResponse(numberA, numberB);
		return addResponse;
	}

	@Override
	public SubtractResponse subtractNumbers(int numberA, int numberB) {
		SubtractResponse subtractResponse = soapClient.getSubtractResponse(numberA, numberB);
		return subtractResponse;
	}

	@Override
	public MultiplyResponse multiplyNumbers(int numberA, int numberB) {
		MultiplyResponse multiplyResponse = soapClient.getMultiplyResponse(numberA, numberB);
		return multiplyResponse;
	}

	@Override
	public DivideResponse divideNumbers(int numberA, int numberB) {
		DivideResponse divideResponse = soapClient.getDivideResponse(numberA, numberB);
		return divideResponse;
	}
	

}

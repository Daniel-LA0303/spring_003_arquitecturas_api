package com.mx.soap.employee.config;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mx.soap.employee.EmployeeWs;

import jakarta.xml.ws.Endpoint;

@Configuration
public class WebServiceConfig {

	@Autowired
	private Bus bus;
	
	@Autowired
	private EmployeeWs employeeService;

	@Bean
	Endpoint endpoint() {
		Endpoint endpoint = new EndpointImpl(bus, employeeService);
		endpoint.publish("/employee");
		return endpoint;

	}

}

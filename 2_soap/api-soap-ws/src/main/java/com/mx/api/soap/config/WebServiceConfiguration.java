package com.mx.api.soap.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfiguration extends WsConfigurerAdapter {

	@Bean(name = "employees")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema employeeSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("apiServiceSoapHttp");
		wsdl11Definition.setLocationUri("/api");
		wsdl11Definition.setTargetNamespace("interfaces.soap.api.mx.com");
		wsdl11Definition.setSchema(employeeSchema);
		return wsdl11Definition;
	}

	@Bean
	public XsdSchema employeeSchema() {
		return new SimpleXsdSchema(new ClassPathResource("employee.xsd"));
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(
			ApplicationContext applicationContext) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(applicationContext); // Usa ApplicationContext en lugar de
															// org.springframework.context.ApplicationContext
		servlet.setTransformWsdlLocations(true);
		return new ServletRegistrationBean<>(servlet, "/api/*");
	}

}
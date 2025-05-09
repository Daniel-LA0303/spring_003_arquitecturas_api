package com.mx.soap.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.mx.soap.client.client.SoapClient;


/**
 * Esta clase define la configuracion de 
 */
@Configuration
public class SoapConfig {

	/**
	 * Consumo de servicio soap
	 * Dependencia Jaxb2Marshaller
	 * Cuando consumimos se llama unmarshalling
	 * Cuando enviamos se llama marshalling
	 */
    @Bean
    public Jaxb2Marshaller marshaller(){
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.mx.soap.client.xmlclases"); //ubicacion de clases xml
        return marshaller;
    }

    /**
     * Esta configuracion es para determinar el cliente y sus metodos
     */
    @Bean
    public SoapClient getSoapClient(Jaxb2Marshaller marshaller){
        SoapClient soapClient = new SoapClient();
        //aqui es donde convertimos la informacion
        soapClient.setDefaultUri("http://www.dneonline.com/calculator.asmx");
        soapClient.setMarshaller(marshaller);
        soapClient.setUnmarshaller(marshaller);

        return soapClient;
    }
}

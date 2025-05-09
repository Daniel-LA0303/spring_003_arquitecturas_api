package com.mx.soap.client.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.mx.soap.client.xmlclases.Add;
import com.mx.soap.client.xmlclases.AddResponse;
import com.mx.soap.client.xmlclases.Divide;
import com.mx.soap.client.xmlclases.DivideResponse;
import com.mx.soap.client.xmlclases.Multiply;
import com.mx.soap.client.xmlclases.MultiplyResponse;
import com.mx.soap.client.xmlclases.Subtract;
import com.mx.soap.client.xmlclases.SubtractResponse;



public class SoapClient extends WebServiceGatewaySupport {

    /**
     * Metodo que se encarga de sumar dos numeros
     *
     * @param numberA
     * @param numberB
     * @return AddResponse
     */
    public AddResponse getAddResponse(int numberA, int numberB) {

        Add addRequest = new Add(); // se contruye la peticion
        addRequest.setIntA(numberA);
        addRequest.setIntB(numberB);

        //solicitud con el metodo, donde el uri se definio en nuestro .wsdl, seguido del nombre del metodo
        SoapActionCallback soapActionCallback = new SoapActionCallback("http://tempuri.org/Add");

        //con ayuda del mapeado del response, se obtiene la respuesta del servicio 
        //se van 3 parametros, la uri del servicio, el mapeo de la clase a xml y el mapeo xml de wsdl 
        AddResponse addResponse = (AddResponse) getWebServiceTemplate().marshalSendAndReceive("http://www.dneonline.com/calculator.asmx", addRequest, soapActionCallback);

        return addResponse;
    }

    /**
     * Metodo que encarga de restar dos numero
     * @param numberA
     * @param numberB
     * @return SubtractResponse
     */
    public SubtractResponse getSubtractResponse(int numberA, int numberB) {

        Subtract subtractRequest = new Subtract();
        subtractRequest.setIntA(numberA);
        subtractRequest.setIntB(numberB);

        SoapActionCallback soapActionCallback = new SoapActionCallback("http://tempuri.org/Subtract");

        SubtractResponse subtractResponse = (SubtractResponse) getWebServiceTemplate().marshalSendAndReceive("http://www.dneonline.com/calculator.asmx", subtractRequest, soapActionCallback);

        return subtractResponse;
    }


    /**
     * Metodo encargado de multiplicar dos numeros
     * @param numberA
     * @param numberB
     * @return MultiplyResponse
     */
    public MultiplyResponse getMultiplyResponse(int numberA, int numberB){

        Multiply multiplyRequest = new Multiply();
        multiplyRequest.setIntA(numberA);
        multiplyRequest.setIntB(numberB);

        SoapActionCallback soapActionCallback = new SoapActionCallback("http://tempuri.org/Multiply");

        MultiplyResponse multiplyResponse = (MultiplyResponse) getWebServiceTemplate().marshalSendAndReceive("http://www.dneonline.com/calculator.asmx", multiplyRequest, soapActionCallback);

        return multiplyResponse;
    }

    /**
     * Metodo encargado de dividir dos numeros
     * @param numberA
     * @param numberB
     * @return DivideResponse
     */
    public DivideResponse getDivideResponse(int numberA, int numberB){

        Divide divideRequest = new Divide();
        divideRequest.setIntA(numberA);
        divideRequest.setIntB(numberB);

        SoapActionCallback soapActionCallback = new SoapActionCallback("http://tempuri.org/Divide");

        DivideResponse divideResponse = (DivideResponse) getWebServiceTemplate().marshalSendAndReceive("http://www.dneonline.com/calculator.asmx", divideRequest, soapActionCallback);

        return divideResponse;
    }
}
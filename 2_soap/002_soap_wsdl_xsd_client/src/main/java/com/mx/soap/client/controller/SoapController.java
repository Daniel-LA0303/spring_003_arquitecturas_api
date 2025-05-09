package com.mx.soap.client.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mx.soap.client.service.SoapService;
import com.mx.soap.client.xmlclases.AddResponse;
import com.mx.soap.client.xmlclases.DivideResponse;
import com.mx.soap.client.xmlclases.MultiplyResponse;
import com.mx.soap.client.xmlclases.SubtractResponse;

@RestController
@RequestMapping("/api/soap")
public class SoapController {
    
    @Autowired
    private SoapService soapService;

    @PostMapping("/sumar")
    public ResponseEntity<?> add(@RequestParam int numberA, @RequestParam int numberB) {
    	
    	AddResponse addResponse = soapService.addNumbers(numberA, numberB);

        Map<String, Integer> response = new HashMap<>();
        response.put("resultado", addResponse.getAddResult());
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/restar")
    public ResponseEntity<?> subtract(@RequestParam int numberA, @RequestParam int numberB) {
        
    	SubtractResponse subtractResponse = soapService.subtractNumbers(numberA, numberB);

        Map<String, Integer> response = new HashMap<>();
        response.put("resultado", subtractResponse.getSubtractResult());
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/multiplicar")
    public ResponseEntity<?> multiply(@RequestParam int numberA, @RequestParam int numberB) {
    	
    	MultiplyResponse multiplyResponse = soapService.multiplyNumbers(numberA, numberB);

        Map<String, Integer> response = new HashMap<>();
        response.put("resultado", multiplyResponse.getMultiplyResult());
        return ResponseEntity.ok().body(response);
    }

    @PostMapping("/dividir")
    public ResponseEntity<?> divide(@RequestParam int numberA, @RequestParam int numberB) {
    	
    	DivideResponse divideResponse = soapService.divideNumbers(numberA, numberB);

        Map<String, Integer> response = new HashMap<>();
        response.put("resultado", divideResponse.getDivideResult());

        return ResponseEntity.ok().body(response);
    }
}
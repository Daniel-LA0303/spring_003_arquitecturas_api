package com.mx.soap.client.api.soap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mx.soap.client.api.soap.model.AddEmployeeInput;
import com.mx.soap.client.api.soap.model.AddEmployeeOutput;
import com.mx.soap.client.api.soap.model.DeleteEmployeeInput;
import com.mx.soap.client.api.soap.model.DeleteEmployeeOutput;
import com.mx.soap.client.api.soap.model.GetAllEmployeesInput;
import com.mx.soap.client.api.soap.model.GetAllEmployeesOutput;
import com.mx.soap.client.api.soap.model.GetOneEmployeeInput;
import com.mx.soap.client.api.soap.model.GetOneEmployeeOutput;
import com.mx.soap.client.api.soap.model.UpdateEmployeeInput;
import com.mx.soap.client.api.soap.model.UpdateEmployeeOutput;
import com.mx.soap.client.api.soap.service.SoapClientService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private SoapClientService soapClientService;

    @PostMapping("/add")
    public ResponseEntity<?> addEmployee(@RequestBody AddEmployeeInput addEmployeeInput) {
        
    	AddEmployeeOutput addEmployeeOutput = soapClientService.addEmployee(addEmployeeInput);
    	
        return ResponseEntity.ok().body(addEmployeeOutput);
    }
    
    @GetMapping
    public ResponseEntity<?> getAllEmployess() {
    	
    	GetAllEmployeesInput getAllEmployeesInput =  new GetAllEmployeesInput();
    	
    	GetAllEmployeesOutput getAllEmployeesOutput = soapClientService.getAllEmployees(getAllEmployeesInput);
        
        return ResponseEntity.ok().body(getAllEmployeesOutput);
    	
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getOneEmployee(@PathVariable long id) {
    	
    	GetOneEmployeeInput getOneEmployeeInput = new GetOneEmployeeInput(id);
    	
    	GetOneEmployeeOutput getOneEmployeeOutput = soapClientService.getEmployee(getOneEmployeeInput);
    	
        return ResponseEntity.ok().body(getOneEmployeeOutput);
    	
    }
    
    @PutMapping()
    public ResponseEntity<?> updateOneEmployee(@RequestBody UpdateEmployeeInput updateEmployeeInput) {
    	
    	UpdateEmployeeOutput updateEmployeeOutput = soapClientService.updateEmployee(updateEmployeeInput);
        
        return ResponseEntity.ok().body(updateEmployeeOutput);
    	
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOneEMployee(@PathVariable long id) {
    	
    	DeleteEmployeeInput deleteEmployeeInput = new DeleteEmployeeInput();
    	deleteEmployeeInput.setId(id);
    	
    	DeleteEmployeeOutput deleteEmployeeOutput = soapClientService.deleteEmployee(deleteEmployeeInput);
    	
        return ResponseEntity.ok().body(deleteEmployeeOutput);
    	
    }
    
}
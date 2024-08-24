package com.mx.api.soap.interfaces;

import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "employeeInfoList" })
@XmlRootElement(name = "getAllEmployeesResponse")
public class GetAllEmployeesResponse {

    @XmlElement(required = true)
    protected List<EmployeeInfo> employeeInfoList;

    public List<EmployeeInfo> getEmployeeInfoList() {
        return employeeInfoList;
    }

    public void setEmployeeInfoList(List<EmployeeInfo> value) {
        this.employeeInfoList = value;
    }
}

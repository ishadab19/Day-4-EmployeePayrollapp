package com.bridgelabz.employeepayrollapp.models;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class EmployeePayrollData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;
    private String name;
    private long salary;

    public EmployeePayrollData() {
    }

    public EmployeePayrollData(int employeeId, EmployeePayrollDTO employeePayrollDTO) {
        this.employeeId = employeeId;
        this.name = employeePayrollDTO.name;
        this.salary = employeePayrollDTO.salary;
    }


}

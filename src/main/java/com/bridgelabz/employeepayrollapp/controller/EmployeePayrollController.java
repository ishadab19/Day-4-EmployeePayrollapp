package com.bridgelabz.employeepayrollapp.controller;


import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.models.EmployeePayrollData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @RequestMapping(value = {"", "/", "/get"})
    public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(1, new EmployeePayrollDTO("Shadab", 189000));
        ResponseDTO respDTO = new ResponseDTO("Get Call Successful", empData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDTO> getEmployeePayRollData(
            @PathVariable("empId") int empId) {
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(empId, new EmployeePayrollDTO("Shadab", 189000));
        ResponseDTO respDTO = new ResponseDTO("Get Call Successfull", empData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addEmployeePayRollData(
            @RequestBody EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(1, empPayrollDTO);
        ResponseDTO respDTO = new ResponseDTO("Created EmpPayRoll Data Successfully ", empData);

        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> updateEmployeePayRollData(
            @RequestBody EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData empData = null;
        empData = new EmployeePayrollData(1, empPayrollDTO);
        ResponseDTO respDTO = new ResponseDTO("Upadated Employee Payroll Data Successfully", empData);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<ResponseDTO> deleteEmployeePayRollData(
            @PathVariable("empId") int empId) {
        ResponseDTO respDTO = new ResponseDTO("Deleted Employee Pay Roll Data And Employee ID is", empId);
        return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
    }

}

package com.bridgelabz.employeepayrollapp.controller;


import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @RequestMapping(value = {"","/","/get"})
    public ResponseEntity<String>getEmployeePayrollData(){
        return new ResponseEntity<String>("Get Call Success", HttpStatus.OK);
    }
    @GetMapping("/get/{empId}")
    public ResponseEntity<String>getEmployeePayRollData(@PathVariable("empId")int empId){
        return  new ResponseEntity<String>("Get Call Success for Id" + empId,HttpStatus.OK);
    }
    @PostMapping ("/create")
    public ResponseEntity<String>addEmployeePayRollData(@RequestBody EmployeePayrollDTO empPayrollDTO){
        return new ResponseEntity<String>("Created EmpLoyeePayRoll Data for : " + empPayrollDTO,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String>updateEmployeePayRollData(@RequestBody EmployeePayrollDTO employeePayrollDTO){
        return new ResponseEntity<String>("Updated EmployeePayroll data for :" +employeePayrollDTO,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<String>deleteEmployeePayRollData(@PathVariable("empId") int empId){
        return new ResponseEntity<String>("Delete Call Success For Id :" +empId ,HttpStatus.OK);
    }

}

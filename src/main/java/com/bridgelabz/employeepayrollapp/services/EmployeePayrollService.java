package com.bridgelabz.employeepayrollapp.services;

import com.bridgelabz.employeepayrollapp.exception.EmpPayRollException;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayRollRepository;
import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.models.EmployeePayrollData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {

    @Autowired
    EmployeePayRollRepository employeePayRollRepository;

    private List<EmployeePayrollData> employeePayrollDataList = new ArrayList<>();


    @Override
    public List<EmployeePayrollData> getEmployeePayrollData() {
        employeePayrollDataList = employeePayRollRepository.findAll();
        return employeePayrollDataList;
    }

    @Override
    public EmployeePayrollData getEmployeePayrollDataById(int empId) {
        Optional<EmployeePayrollData> employeePayrollData = employeePayRollRepository.findById(empId);
        if (employeePayrollData.isPresent()) {
            return employeePayrollData.get();
        } else {
            throw new EmpPayRollException("Id Not Found..!!");
        }

    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData employeePayrollData = new EmployeePayrollData(empPayrollDTO);
        return employeePayRollRepository.save(employeePayrollData);
    }


    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
        Optional<EmployeePayrollData> employeePayrollData = employeePayRollRepository.findById(empId);
        if (employeePayrollData.isPresent()) {
            EmployeePayrollData empData = new EmployeePayrollData(empId, employeePayrollDTO);
            employeePayRollRepository.save(empData);
            return empData;
        } else {
            throw new EmpPayRollException("Id Not Found..!!!");
        }
    }

    @Override
    public void deleteEmployeePayrollData(int empId) {
        Optional<EmployeePayrollData> employeePayrollData = employeePayRollRepository.findById(empId);
        if (employeePayrollData.isPresent()) {
            employeePayRollRepository.deleteById(empId);

        } else {
            throw new EmpPayRollException("Id Not Found..!!!");
        }
    }

    @Override
    public List<EmployeePayrollData> getEmployeeByDepartment(String department) {
        List<EmployeePayrollData> employeePayrollData = employeePayRollRepository.findByDepartment(department);
        return employeePayrollData;
    }

    }




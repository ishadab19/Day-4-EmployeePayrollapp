package com.bridgelabz.employeepayrollapp.services;

import com.bridgelabz.employeepayrollapp.exception.EmpPayRollException;
import com.bridgelabz.employeepayrollapp.repository.EmployeePayRollRepository;
import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.models.EmployeePayrollData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        if (employeePayRollRepository.findById(empId).isPresent())
            return employeePayRollRepository.findById(empId).get();
        else
            throw new EmpPayRollException("Id Not Found !!");

    }

    @Override
    public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
        EmployeePayrollData employeePayrollData = new EmployeePayrollData(empPayrollDTO);
        return employeePayRollRepository.save(employeePayrollData);
    }


    @Override
    public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO employeePayrollDTO) {
        EmployeePayrollData employeePayrollData = new EmployeePayrollData(employeePayrollDTO);
        employeePayrollData.setEmployeeId(empId);
        return employeePayRollRepository.save(employeePayrollData);
    }

    @Override
    public void deleteEmployeePayrollData(int empId) {
        employeePayrollDataList.remove(empId - 1);

    }
}

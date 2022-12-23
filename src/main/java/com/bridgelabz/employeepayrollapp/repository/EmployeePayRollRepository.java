package com.bridgelabz.employeepayrollapp.repository;

import com.bridgelabz.employeepayrollapp.models.EmployeePayrollData;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface EmployeePayRollRepository extends JpaRepository <EmployeePayrollData,Integer>{


   @Query(value = "select * from employee_payroll, employee_department where employee_id = id and department =:department",nativeQuery = true)


    List<EmployeePayrollData> findByDepartment(String department);
}

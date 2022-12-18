package com.bridgelabz.employeepayrollapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
@Slf4j
public class EmployeePayrollApplication {

    public static void main(String[] args) {
       // SpringApplication.run(EmployeePayrollAppApplication.class, args);
        ApplicationContext context = SpringApplication.run
                (EmployeePayrollApplication.class,args);
        log.info("Employee PayRoll App Started");
        System.out.println("Welcome to EmpPayRollApp");
    }

}

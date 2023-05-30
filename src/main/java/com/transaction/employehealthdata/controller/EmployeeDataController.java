package com.transaction.employehealthdata.controller;

import com.transaction.employehealthdata.exceptionhandler.NegitiveValueException;
import com.transaction.employehealthdata.models.Employee;
import com.transaction.employehealthdata.service.CreateEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeDataController {
    @Autowired
    CreateEmployee createEmployee;


    @PostMapping("/employee")
    public ResponseEntity<?> addEmployee(@RequestBody Employee e) throws NegitiveValueException {
        System.out.println(e.getEmployeeName());
   createEmployee.updateEmployeeDetails(e);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

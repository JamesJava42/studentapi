package com.transaction.employehealthdata.service;

import com.transaction.employehealthdata.exceptionhandler.NegitiveValueException;
import com.transaction.employehealthdata.models.Employee;
import com.transaction.employehealthdata.repos.EmplyeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateEmployee {
    @Autowired
    EmplyeeRepo emplyeeRepo;
    @Transactional(rollbackFor = NegitiveValueException.class)
    public  void updateEmployeeDetails(Employee employee) throws NegitiveValueException {
        emplyeeRepo.save(employee);  //At this point , with out the transactional annotatio as rollback , data has to get saved in DB
//        but using the @Transactional rollbask even saved data based on the exception it get reverted.
        if(Integer.parseInt(employee.getHealthdata().getInsurenceCoveramount()) <0){
            throw new NegitiveValueException("Negtiva value not allowe");
        }
        emplyeeRepo.save(employee);

    }
}

package com.transaction.employehealthdata.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "employee")
public class Employee {
    @Id
    @Column(name = "emp_id")
    int employeeId;
    @Column(name = "emp_name")
    String employeeName;
    @Column(name = "emp_city")
    String employeeCity;
    @OneToOne(cascade = CascadeType.ALL)
            @JoinColumn(name = "fk_health")
    Healthdetails healthdata;




}

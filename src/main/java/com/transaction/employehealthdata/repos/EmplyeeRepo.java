package com.transaction.employehealthdata.repos;

import com.transaction.employehealthdata.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmplyeeRepo extends JpaRepository<Employee,Integer> {

}

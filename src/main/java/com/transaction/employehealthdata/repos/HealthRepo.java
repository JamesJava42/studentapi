package com.transaction.employehealthdata.repos;

import com.transaction.employehealthdata.models.Healthdetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthRepo extends JpaRepository<Healthdetails,Integer> {
}

package com.relation.hibernate.dao;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.relation.hibernate.model.Studentclass;

public interface Studentclassdao extends JpaRepository<Studentclass, Integer> {
	
	@Query(value = "select sc from Studentclass sc where sc.id= :id")
	public List<Studentclass> getPromotionRecord(@Param("id") int id);
	
	
	@Query(value = "update  Studentclass s set s.promotion= s.promotion+1 where id= :id")
	public void updateStudentClass(@Param("id") int id);
	
	
	
	
	//@Query(value = "select sc.promotion , m.stand from Studentclass sc inner join marks m where sc.s_s_id = m.sid and oder by desc limit 1")
}

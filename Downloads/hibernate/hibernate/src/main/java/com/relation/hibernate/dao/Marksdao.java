package com.relation.hibernate.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.relation.hibernate.model.Marks;

public interface Marksdao extends JpaRepository<Marks, Integer>{
	
	@Query("select m from Marks m where m.sid = :id order by year desc limit 1")
	public  List<Marks> getMarks(@Param("id") int id) ;

	
	
	
	
	
	
//	@Query("select m from Studentclass s innerjoin Marks m on ")
//	public void updateYear();
	
	
	
	
}

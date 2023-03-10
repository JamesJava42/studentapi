package com.relation.hibernate.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.relation.hibernate.model.Student;
import com.relation.hibernate.view.Response;
@Repository
public interface Studentdao  extends JpaRepository<Student, Integer>{
	@Query(value =  "select s from Student s where s.sid = :id" )
	public List<Student> getStudent( @Param("id") int id);
	
	
	@Query(value = "select com.relation.hibernate.view.Response(s.age , s.city, s.name) from Student s where s.sid= :id")
	public List<Response> getStudent1( @Param("id") int id);


}

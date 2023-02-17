package com.relation.hibernate.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.relation.hibernate.model.User;



public interface Userrepo extends JpaRepository<User, Integer> {
	
	@Query("select u from User u where u.username = :id ")
	public List<User> getStudents(@Param("id") String  id);
	
	

}

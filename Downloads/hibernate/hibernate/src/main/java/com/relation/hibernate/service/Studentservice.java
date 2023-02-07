package com.relation.hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relation.hibernate.dao.Studentdao;
import com.relation.hibernate.model.Clas;
import com.relation.hibernate.model.Student;
@Service
public class Studentservice {
	
	@Autowired
	static Studentdao dao;
	

	 public static void main(String []args) {
		 Student objs = new Student();
		 objs.setName("Rakesh");
		 objs.setCity("cumbum");
		 objs.setAge(11);
		 
		 Clas objc = new Clas();
		 objc.setStandard(8);
		 
		 dao.save(objs);
		 
		 
		 
		 
		
		
		 
		 
		 
		 
		 
		 
	 }
	
	

}

package com.relation.hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relation.hibernate.dao.Marksdao;
import com.relation.hibernate.dao.Studentclassdao;
import com.relation.hibernate.dao.Studentdao;
import com.relation.hibernate.model.Clas;
import com.relation.hibernate.model.Marks;
import com.relation.hibernate.model.Student;
@Service
public class Studentservice {
	
	@Autowired
	static Studentdao dao;
	@Autowired
	static Marksdao mdao;
	
	@Autowired
	static Studentclassdao scdao;
	
	public static Marks getMarks(int id) {
		
		if(mdao.findById(id) != null ) {
			
			Marks data =  mdao.getById(id);
			return data;
		}
		else {
			return null;
		}
		
		
		
	}
	
	public static Boolean isPromoted(int id) {
		if(mdao.findById( id) != null) {
			Marks data = mdao.getById(id);
			if(data.getGpa() > 7) {
				//update the promotion field 
				scdao.updateStudentClass(id);
				//and year and standard return message promoted;
//				scdao.updateStudentClass(id);
				return true;
			}
		}
		return false;
		
	}
	

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

package com.relation.hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.relation.hibernate.dao.Marksdao;
import com.relation.hibernate.dao.Studentclassdao;
import com.relation.hibernate.dao.Studentdao;
import com.relation.hibernate.exception.StudentExistException;
import com.relation.hibernate.model.Clas;
import com.relation.hibernate.model.Marks;
import com.relation.hibernate.model.Student;
import com.relation.hibernate.model.Studentclass;
@Service
@Component
public class Studentservice {
	
	
	@Autowired
	 Marksdao mdao;
	
	@Autowired
	 Studentclassdao scdao;
	
	@Autowired
	
   Studentdao studentdao;
	
	public  Marks getMarks(int id) {
		
		if(mdao.findById(id) != null ) {
			
			Marks data =  mdao.getById(id);
			return data;
		}
		else {
			return null;
		}
	
		
		
		
	}
	
	public int isExist(int  studentId) {
		System.out.println("Entered lto the isExist method ");
		List<Student> out = studentdao.getStudent(studentId);

		if(!out.isEmpty()) {
			return 0;
		}else {
			//List<Student> out =  studentdao.getStudent(studentId);
			throw new StudentExistException("Already Exists");
		}
		
			
		}
		
		
	
	
	public Boolean isPromoted(int id) {
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
	

	 
	

}

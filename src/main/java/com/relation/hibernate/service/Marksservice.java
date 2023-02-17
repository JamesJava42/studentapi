package com.relation.hibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.function.ServerResponse.SseBuilder;

import com.relation.hibernate.dao.Marksdao;
import com.relation.hibernate.dao.Studentdao;
import com.relation.hibernate.model.Marks;
import com.relation.hibernate.model.Student;

public class Marksservice {
	
	@Autowired
	 Marksdao marksdao;
	
//	@Autowired
//	Studentdao studentdao;
//	@Autowired
//	Studentservice ss;
	
	
	
	
	public  boolean getStudent(int id) {
		List<Marks> m = marksdao.getMarks(id);
		if(m.size()>0) {
			System.out.println("We are in get student method object exists");
			return true;
	
		}
		return false;
	}
	public  int getStandard(int id) {
		List<Marks> m1 = marksdao.getMarks(id);
		if(!m1.isEmpty()) {
			Marks out  = m1.get(0);
			int stand = out.getStandard();
			return stand;
	
		}
		return 0;
		
	}
	
	
	

}

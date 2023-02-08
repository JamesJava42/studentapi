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
	static Marksdao mdao;
	
	@Autowired
	static Studentdao sdao;
	@Autowired
	static Studentservice ss;
	
	
	
	
	public static boolean getStudent(int id) {
		List<Marks> m = mdao.getMarks(id);
		if(!m.isEmpty()) {
			return true;
	
		}
		return false;
	}
	public static int getStandard(int id) {
		List<Marks> m1 = mdao.getMarks(id);
		if(!m1.isEmpty()) {
			Marks out  = m1.get(0);
			int stand = out.getStandard();
			return stand;
	
		}
		return 0;
		
	}
	
	
	

}

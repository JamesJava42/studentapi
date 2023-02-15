package com.relation.hibernate.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.relation.hibernate.dao.Studentclassdao;
import com.relation.hibernate.dao.Studentdao;
import com.relation.hibernate.model.Studentclass;

public class Studentclassservice {
	@Autowired
	Studentclassdao studentclassdao;
	@Autowired
	Studentdao studentdao;
	
	public  int getPromoted(int id) {
		if(studentdao.findById(id) != null) {
			System.out.println("We are in promoted method");
			List<Studentclass> out = studentclassdao.getPromotionRecord(id);
			if(out.size() >0) {
				System.out.println("Student exists");
			    Studentclass res = out.get(0);
			    res.setPromotion(res.getPromotion()+1);
			    studentclassdao.saveAndFlush(res);
			    return 1;
			}
			
		//scdao.updateStudentClass(id);
		}
		return 0;
		
	}

	public int getPromotion(int id) {
		List<Studentclass> sr = studentclassdao.getPromotionRecord(id);
		System.out.println("The getPromotion method size :"+sr.size());
		if(sr.size()>0) {
		Studentclass scd = sr.get(0);
		   return scd.getPromotion();
		}
		return 0;
		
		
	}

}

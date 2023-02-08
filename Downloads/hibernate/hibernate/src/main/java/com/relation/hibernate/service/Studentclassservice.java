package com.relation.hibernate.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.relation.hibernate.dao.Studentclassdao;
import com.relation.hibernate.dao.Studentdao;
import com.relation.hibernate.model.Studentclass;

public class Studentclassservice {
	@Autowired
	static Studentclassdao scdao;
	@Autowired
	static Studentdao sdao;
	
	public static void getPromoted(int id) {
		if(sdao.findById(id) != null) {
		scdao.updateStudentClass(id);
		}
		
		
	}

	public int getPromotion(int id) {
		List<Studentclass> sr = scdao.getPromotionRecord(id);
		Studentclass scd = sr.get(0);
		
		return scd.getPromotion();
	}

}

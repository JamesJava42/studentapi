package com.relation.hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.relation.hibernate.dao.Classdao;
import com.relation.hibernate.dao.Marksdao;
import com.relation.hibernate.dao.Studentclassdao;
import com.relation.hibernate.dao.Studentdao;
import com.relation.hibernate.model.Clas;
import com.relation.hibernate.model.Marks;
import com.relation.hibernate.model.Student;
import com.relation.hibernate.model.Studentclass;

@RestController()
@RequestMapping("/add/")
public class Req {
	@Autowired
	Studentdao studentd;
	
	@Autowired
	Studentclassdao scdao;
	
	@Autowired
	Classdao cdao;
	
	@Autowired
	Marksdao mdao;
	
	@PostMapping("student")
	public ResponseEntity<?> addStudent(@RequestBody Student s){
		studentd.save(s);
		return new ResponseEntity<>("Sucessfull "+s.getSid(),HttpStatus.OK);
		
	}
	
	
	
	@PostMapping("studentclas")
	public ResponseEntity<?> addStudent(@RequestBody Studentclass s){
		/*
		 * Studentclass sc = new Studentclass(); sc.setClas(s.getClas());
		 * sc.setPromotion(s.getPromotion()); sc.setStudent(s.getStudent());
		 * sc.setId(0); scdao.save(sc);
		 */
		scdao.save(s);
		return new ResponseEntity<>("Sucessfull "+s.getId(),HttpStatus.OK);
		
	}
	
	@PostMapping("class")
	public ResponseEntity<?> addClass(@RequestBody Clas c){
		cdao.save(c);
		return new ResponseEntity<>("Class added Sucessfull :"+c.getId(),HttpStatus.OK);
		
	}
	
	@PostMapping("marks/add")
	public ResponseEntity<?> addMarks(@RequestBody Marks m){
		double total = m.getSub1()+m.getSub2()+m.getSub3();
		m.setMarks(total);
		float gpa = (float)total/10;
		m.setGpa(gpa);
		mdao.save(m);
		return new ResponseEntity<>("Marks added succesfull : "+m.getMid(),HttpStatus.OK);
	}
	
	
	
	
	
	
	

}

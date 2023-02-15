package com.relation.hibernate.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.relation.hibernate.service.Marksservice;
import com.relation.hibernate.service.Studentclassservice;

@RestController()
@RequestMapping("/add/")
public class Req {
	@Autowired
	Studentdao studentdao;
	
	@Autowired
	Studentclassdao studentclassdao;
	
	@Autowired
	Classdao classdao;
	
	@Autowired
	Marksdao marksdao;
	
	@Autowired
	Marksservice marksservice;
	
	@Autowired
	Studentclassservice studentclassservice;
	
	
	
	Logger o = LoggerFactory.getLogger(Req.class);
	
	@PostMapping("student")
	public ResponseEntity<?> addStudent(@RequestBody Student s){
		studentdao.save(s);
		return new ResponseEntity<>("Sucessfull "+s.getSid(),HttpStatus.OK);
		
	}
	
	
	
	@PostMapping("studentclas")
	public ResponseEntity<?> addStudent(@RequestBody Studentclass s){
		/*
		 * Studentclass sc = new Studentclass(); sc.setClas(s.getClas());
		 * sc.setPromotion(s.getPromotion()); sc.setStudent(s.getStudent());
		 * sc.setId(0); scdao.save(sc);
		 */
		studentclassdao.save(s);
		return new ResponseEntity<>("Sucessfull "+s.getId(),HttpStatus.OK);
		
	}
	
	@PostMapping("class")
	public ResponseEntity<?> addClass(@RequestBody Clas c){
		classdao.save(c);
		return new ResponseEntity<>("Class added Sucessfull :"+c.getId(),HttpStatus.OK);
		
	}
	
	@PostMapping("marks/add")
	public ResponseEntity<?> addMarks(@RequestBody Marks m){
		
		double total = m.getSub1()+m.getSub2()+m.getSub3();
		m.setMarks(total);
		
		float gpa = (float)total/10;
		
		
		m.setGpa(gpa);
		o.info("The caluculated gpa :"+gpa);
		
		if(m.getGpa() > 5.0) {
			
			int status = studentclassservice.getPromoted(m.getSid());
			if(status == 0) {
				return new ResponseEntity<>("Student Record NotExists :",HttpStatus.NOT_FOUND);
			}
			
			o.info("We are promoted the student based on gpa");
			
		}
		o.info("after promoted");
		//get the stand from 
		
		if(marksservice.getStudent(m.getSid())) {
			int stan = marksservice.getStandard(m.getSid());
			int prom = studentclassservice.getPromotion(m.getSid());
			m.setStandard(prom);
			o.info("we are updating the standard ");
		}
		//checking the student result and updating the promotion field
		
		
		
		
		
		marksdao.save(m);
		return new ResponseEntity<>("Marks added succesfull : "+m.getMid(),HttpStatus.OK);
	}
	
	
	
	
	
	
	

}

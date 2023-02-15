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
	
	
	
	Logger objectMapper = LoggerFactory.getLogger(Req.class);
	
	
	
	
	
	@PostMapping("studentclas")
	public ResponseEntity<?> addStudent(@RequestBody Studentclass studentClassBody){
		/*
		 * Studentclass sc = new Studentclass(); sc.setClas(studentClassBody.getClas());
		 * sc.setPromotion(studentClassBody.getPromotion()); sc.setStudent(studentClassBody.getStudent());
		 * sc.setId(0); scdao.save(sc);
		 */
		studentclassdao.save(studentClassBody);
		return new ResponseEntity<>("Sucessfull "+studentClassBody.getId(),HttpStatus.OK);
		
	}
	
	
	
	@PostMapping("marks/add")
	public ResponseEntity<?> addMarks(@RequestBody Marks marks){
		
		double total = marks.getSub1()+marks.getSub2()+marks.getSub3();
		marks.setMarks(total);
		
		float gpa = (float)total/10;
		
		
		marks.setGpa(gpa);
		objectMapper.info("The caluculated gpa :"+gpa);
		
		if(marks.getGpa() > 5.0) {
			
			int status = studentclassservice.getPromoted(marks.getSid());
			if(status == 0) {
				return new ResponseEntity<>("Student Record NotExists :",HttpStatus.OK);
			}
			
			objectMapper.info("We are promoted the student based on gpa");
			
		}
		objectMapper.info("after promoted");
		//get the stand from 
		
		if(marksservice.getStudent(marks.getSid())) {
			int stand = marksservice.getStandard(marks.getSid());
			int prom = studentclassservice.getPromotion(marks.getSid());
			marks.setStandard(prom);
			objectMapper.info("we are updating the standard ");
		}
		//checking the student result and updating the promotion field
		
		
		
		
		
		marksdao.save(marks);
		return new ResponseEntity<>("Marks added succesfull : "+marks.getMid(),HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	@PostMapping("class")
	public ResponseEntity<?> addClass(@RequestBody Clas c){
		classdao.save(c);
		return new ResponseEntity<>("Class added Sucessfull :"+c.getId(),HttpStatus.OK);
		
	}
	
	
	
	@PostMapping("student")
	public ResponseEntity<?> addStudent(@RequestBody Student studentClassBody){
		studentdao.save(studentClassBody);
		return new ResponseEntity<>("Sucessfull "+studentClassBody.getSid(),HttpStatus.OK);
		
	}
	
	
	

}

package com.relation.hibernate.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.relation.hibernate.dao.Studentclassdao;
import com.relation.hibernate.dao.Studentdao;
import com.relation.hibernate.model.Student;
import com.relation.hibernate.view.Response;

import jakarta.websocket.server.PathParam;
@RestController
@Repository("/")
public class Requestclass {
	@Autowired
	Studentdao studentdao;
	@Autowired
	Studentclassdao scdao;
	
	@Autowired
	Studentdao sdao;
	
	ObjectMapper om = new ObjectMapper();
	
	
	@GetMapping("students")
	public ResponseEntity<?> getStudents(){
		List<Student> out  = studentdao.findAll();
		
		List<TreeNode> res = new ArrayList<>();
		
		for(Student s : out) {
			TreeNode json =  om.valueToTree(s);
			om.convertValue(json, Student.class);
			res.add(json);
			
		}
		return new ResponseEntity<>("Studnets are :"+res,HttpStatus.OK);
		
	
		
	}
	
	
	@GetMapping("studentid")
	public ResponseEntity<?> getById(@RequestParam int id){
		if(studentdao.findById(id) != null) {
			List<Response> s = sdao.getStudent1(id);
			List<TreeNode> res = new ArrayList<>();

			for(Response st : s) {
				TreeNode val  = om.valueToTree(st);
				om.convertValue(val, Response.class);
				res.add(val);
			}
			
			return new ResponseEntity<>("Student is :"+res,HttpStatus.OK);
		}
		
		return new ResponseEntity<>("No student exist ",HttpStatus.OK);
	}

}

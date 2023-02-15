package com.relation.hibernate.controller;


import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.relation.hibernate.dao.Studentclassdao;
import com.relation.hibernate.dao.Studentdao;
import com.relation.hibernate.dao.Userrepo;
import com.relation.hibernate.model.Student;
import com.relation.hibernate.model.User;
import com.relation.hibernate.security.Security;
import com.relation.hibernate.view.Response;

import jakarta.servlet.http.HttpServletRequest;
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
	

	@Autowired
	Security security;

	@Autowired 
	Userrepo repo;
	
	
	ObjectMapper om = new ObjectMapper();
	
	Logger log = LoggerFactory.getLogger(Requestclass.class);
	
	
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
	
	@GetMapping("/login")
	public ResponseEntity<?> userLogin(   HttpServletRequest req){
//		String username = u.getUsername();
//		String password = u.getPassword();
//		
		String sreq  =  req.getHeader("AUTHORIZATION");
		int idx = sreq.indexOf("Basic ");
		String sub = (String) sreq.subSequence(idx, sreq.length());
		String decode = sreq.split(" ")[1];
		byte[] text =    Base64.getDecoder().decode(decode);
		
		String out = new String(text);
		
		String username= out.split(":")[0];
		String password = out.split(":")[1];

	
		log.info("The username and password taken from request is :"+username+" password is : "+password);
		
		UsernamePasswordAuthenticationToken obj = new UsernamePasswordAuthenticationToken(username, password);
		
		log.info("The Initial Userpasswordauthentication token is : "+obj);
		
		
		Authentication tok = security.daoAuthenticationProvider().authenticate(obj);
	  // Authentication token = 	auth.authenticate(obj);  //Have send the token to the manager.
	   log.info("The authentication  token  :"+ tok +" user name in token :  "+tok.getName());
	   
	   log.info("The SecurityContextHolder authentication response  is : "+SecurityContextHolder.getContext().getAuthentication());
		
		
		
        if(tok.isAuthenticated()) {
        	
        	return new ResponseEntity<>("Data",HttpStatus.OK);
			
		}
        throw new UsernameNotFoundException("User Not Authenticated ");
		
		
		
        /*
         * 
		//boolean result = obj.isAuthenticated();
        //Authentication autobject = 		auth.authenticate(obj);
        //System.out.println("The Authencation Boolean object seted as :"+result);
         * 
		//return new ResponseEntity<>("Wellcome",HttpStatus.OK);
		 * //security.daoAuthenticationProvider();
		//security.authenticationManagerBean(obj);
		 * //Authentication au = auth.authenticate(obj);
		 * 
		 * */
	}
	@GetMapping("/data")
	public ResponseEntity<?> getData( ){
		return new ResponseEntity<>("Data",HttpStatus.OK);
		
		
	}
	@PostMapping("/add/user")
	public ResponseEntity<?> addUser(@RequestBody User u){
		User obj = new User();
		obj.setId(u.getId());
		obj.setPassword(u.getPassword());
		obj.setUsername(u.getUsername());
		repo.save(obj);
		return new ResponseEntity<>("Sucessfult"+u.getUsername(),HttpStatus.OK);
		
	}


}

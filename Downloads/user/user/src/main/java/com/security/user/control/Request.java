package com.security.user.control;

import java.util.Base64;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.user.model.User;
import com.security.user.repo.Userrepo;
import com.security.user.security.Security;

import jakarta.servlet.http.HttpServletRequest;

@RestController


public class Request {
	
	
	//Logger-Setup 
	Logger log = LoggerFactory.getLogger(Request.class);
	
	
	@Autowired
	Security security;

	@Autowired 
	Userrepo repo;
	
	
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

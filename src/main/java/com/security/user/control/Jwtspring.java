package com.security.user.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.user.model.Authreq;
import com.security.user.security.Security;
import com.security.user.service.Jwtservice;

@RestController
public class Jwtspring {
	
	
	@Autowired
	Authreq authreq;
	
	@Autowired
	Jwtservice jwtservice;
	
	@Autowired
	Security security;
	
	@PostMapping("/auth")
	public ResponseEntity<?> genrateJwtToken(@RequestBody Authreq authreq){
		String username = authreq.getUsername();
		String password = authreq.getPassword();
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
		
		 Authentication  obj =  security.daoAuthenticationProvider().authenticate(authenticationToken);
		
		String token = jwtservice.getToken(username);
		
		return new ResponseEntity<>(token,HttpStatus.OK);
	}
	@GetMapping("/message")
	public ResponseEntity<?> getMessage(){
		return new ResponseEntity<>("THe data is encrypted" , HttpStatus.OK);
	}

}

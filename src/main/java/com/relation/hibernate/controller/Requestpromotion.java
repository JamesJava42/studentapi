package com.relation.hibernate.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/promote")
public class Requestpromotion {
	
	
	@PutMapping("/promote")
	public ResponseEntity<?> checkpromoted(@RequestParam int id){
		return null;
		
		
	}
}

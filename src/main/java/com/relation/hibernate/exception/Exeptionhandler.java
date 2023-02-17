package com.relation.hibernate.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.persistence.EntityExistsException;
@ControllerAdvice
public class Exeptionhandler extends ResponseEntityExceptionHandler {
	
	
	@ExceptionHandler(StudentExistException.class)
	public ResponseEntity<?> handlingStudentException(StudentExistException studentExistException , WebRequest request){
		
		Exceptionobject obj = new Exceptionobject("Student Exists",201,LocalDateTime.now().toString());
		return new ResponseEntity<>(obj,HttpStatus.OK);
		
	}
	
	

}

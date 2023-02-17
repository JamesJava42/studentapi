package com.relation.hibernate.exception;

import jakarta.persistence.EntityExistsException;

public class StudentExistException  extends RuntimeException{
	
	public StudentExistException() {
		super();
	}
	public StudentExistException(String message) {
		super("User already exists");
	}

}

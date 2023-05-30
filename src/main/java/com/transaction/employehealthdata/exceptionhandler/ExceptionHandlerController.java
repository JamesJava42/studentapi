package com.transaction.employehealthdata.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(NegitiveValueException.class)
    public ResponseEntity<?> negtiveException(NegitiveValueException e, WebRequest wreq){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);

    }


}

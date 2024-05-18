package com.self.BookStore;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyControllerAdvice {
	
	
	//User defined exception as per business
	@ExceptionHandler(EmptyBookStoreException.class)
	public ResponseEntity<String> EmptyBookStoreException(EmptyBookStoreException emptyBookStore){
		return new  ResponseEntity<String>("No Books available in the DB",HttpStatus.BAD_REQUEST);
		
	}
	
	//Pre-defined by spring Boot
	@ExceptionHandler(NoSuchElementException.class)
	public  ResponseEntity<String> noSuchElementFound(NoSuchElementException noSuchElemet){
		return new ResponseEntity<String>("No id match with this element",HttpStatus.NOT_FOUND);
	}
	
}

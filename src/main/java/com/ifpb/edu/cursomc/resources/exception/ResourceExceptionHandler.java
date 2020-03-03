package com.ifpb.edu.cursomc.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.ifpb.edu.cursomc.services.exceptions.DataIntegretyException;
import com.ifpb.edu.cursomc.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandartError> objectNotFound(ObjectNotFoundException e,
			HttpServletRequest request ) {
			
		StandartError err = new StandartError(HttpStatus.NOT_FOUND.value(), e.getMessage(), 
				System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
		
	}
	
	@ExceptionHandler(DataIntegretyException.class)
	public ResponseEntity<StandartError> dataIntegrety(DataIntegretyException e,
			HttpServletRequest request ) {
			
		StandartError err = new StandartError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), 
				System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
		
	}
}

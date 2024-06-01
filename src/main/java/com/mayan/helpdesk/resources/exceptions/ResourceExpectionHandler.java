package com.mayan.helpdesk.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mayan.helpdesk.services.exceptions.ObjectnotFoundException;

@ControllerAdvice // Definir metodos que lidam com exceções. Pode ser utilizado para manipular erros de validação de objetos.
public class ResourceExpectionHandler {

	@ExceptionHandler(ObjectnotFoundException.class)
	public ResponseEntity<StandardError> objectnotFoundException(ObjectnotFoundException ex, HttpServletRequest request) {
		
	StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
			"Object Not Found", ex.getMessage(), request.getRequestURI()); 
	
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
}

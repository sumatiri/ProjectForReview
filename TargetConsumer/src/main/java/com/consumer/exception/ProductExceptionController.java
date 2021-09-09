package com.consumer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionController {
   @ExceptionHandler(value = ProductNotFoundException.class)
   public ResponseEntity<Object> exception(ProductNotFoundException exception) {
	   System.out.println("WITHIN RESPONSE ENTITY HANDLER");
      return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
   }
   
   @ExceptionHandler(value = ProductGenericException.class)
   public ResponseEntity<Object> exception(ProductGenericException exception) {
	   System.out.println("WITHIN RESPONSE ENTITY HANDLER");
      return new ResponseEntity<>("Product not created in DB", HttpStatus.INTERNAL_SERVER_ERROR);
   }
}
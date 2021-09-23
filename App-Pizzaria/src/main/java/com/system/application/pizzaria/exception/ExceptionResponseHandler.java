package com.system.application.pizzaria.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ExceptionResponseHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(GenericException.class)
    protected ResponseEntity<GenericException> handleMethodArgumentNotValid(GenericException ex) {
        return new ResponseEntity<GenericException>(ex, ex.getHttpStatus());
    }
}

package com.nirdosh.api.errorhandling;

import com.nirdosh.domain.model.errors.ApplicationExeption;
import com.nirdosh.domain.model.errors.UserNotFoundException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
    @ExceptionHandler(value = {IllegalArgumentException.class, ApplicationExeption.class})
    protected ResponseEntity<Object> handleConflict(RuntimeException re, WebRequest request){
        return handleExceptionInternal(
            re, re.getMessage(),new HttpHeaders(), HttpStatus.CONFLICT, request
        );
    }
}

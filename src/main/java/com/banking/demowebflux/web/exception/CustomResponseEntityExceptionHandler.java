package com.banking.demowebflux.web.exception;

import com.banking.demowebflux.core.exception.ElementNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomResponseEntityExceptionHandler {

    @ExceptionHandler(ElementNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String elementNotFoundExceptionHandler(Exception ex) {
        return ex.getMessage();
    }
}

package com.beer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class RecipeNotFoundException extends RuntimeException{

    public RecipeNotFoundException(Long id) {
        super("Could not find recipe " + id);
    }
}

@ControllerAdvice
class RecipeNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(RecipeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(RecipeNotFoundException ex) {
        return ex.getMessage();
    }
}
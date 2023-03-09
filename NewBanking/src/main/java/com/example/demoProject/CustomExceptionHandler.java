package com.example.demoProject;

import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public interface CustomExceptionHandler
{
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public default ResponseEntity handle(MethodArgumentNotValidException ex) {

        Map<String, Object> response = new HashMap<>();
        response.put("message", ex.getAllErrors().get(0).getDefaultMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}

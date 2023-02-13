package com.nadex.bussroute.exception;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.*;

@ControllerAdvice
public class ExceptionAdvisor extends ResponseEntityExceptionHandler {
        @ExceptionHandler(ConstraintViolationException.class)
    protected ResponseEntity<Object> handleFieldsNotValid(ConstraintViolationException ex) {
        Map<String,Object> responseBody = new LinkedHashMap<>();
        StringBuilder buffer = new StringBuilder();
        int counter = 1;

        responseBody.put("timestamp", LocalDateTime.now());
        for (ConstraintViolation<?> violation :ex.getConstraintViolations()) {
            buffer.append(violation.getPropertyPath().toString()).append(": ");
            buffer.append(violation.getMessage());
            responseBody.put(String.format("error: %d",counter),buffer.toString());
            buffer.setLength(0);
            counter++;
        }
        return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);
    }
}

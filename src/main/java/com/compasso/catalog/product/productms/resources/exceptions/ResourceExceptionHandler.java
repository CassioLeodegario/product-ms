package com.compasso.catalog.product.productms.resources.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> validation(MethodArgumentNotValidException e, HttpServletRequest request) {

        List<String> errors = new ArrayList<>();
        for (FieldError x : e.getBindingResult().getFieldErrors()) {
            errors.add(x.getDefaultMessage());
        }
        String errorMessage = String.join(", ", errors);
        StandardError err = new StandardError(HttpStatus.BAD_REQUEST.value(), errorMessage);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }

}

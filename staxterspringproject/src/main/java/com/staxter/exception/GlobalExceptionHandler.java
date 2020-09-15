package com.staxter.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {UserAlreadyExistsException.class})
    public ResponseEntity userNameConflict(UserAlreadyExistsException ex) {
        ErrorResponse response = new ErrorResponse();
        response.setCode(ex.getCode());
        response.setDescription(ex.getDescription());

        return new ResponseEntity(response, HttpStatus.CONFLICT);
    }
}

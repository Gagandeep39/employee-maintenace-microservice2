/**
 * @author Pranav
 */


package com.cg.employeeloginservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestErrorHandler {
    
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleErrorResponse(UserNotFoundException exception)
    {
        ErrorResponse response= new ErrorResponse();
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setMessage(exception.getMessage());
        response.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> catchAllException(Exception exception)
    {
        ErrorResponse response= new ErrorResponse();
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setMessage(exception.getMessage());
        response.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }
}
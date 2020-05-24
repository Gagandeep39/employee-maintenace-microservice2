/**
 * @author Pranav
 */


package com.cg.employeeleaveservice.exception;

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
        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setMessage(exception.getMessage());
        response.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleErrorResponse(LeaveNotFoundException exception)
    {
        ErrorResponse response= new ErrorResponse();
        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setMessage(exception.getMessage());
        response.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
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
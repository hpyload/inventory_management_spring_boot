package com.back_end.handler;

import com.back_end.exception.InvalidResourceException;
import com.back_end.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDto> handleResourceNotFoundException(ResourceNotFoundException exception) {
        ErrorDto errorDto = new ErrorDto(new Date(),
                ErrorCode.RESOURCE_NOT_FOUND, exception.getMessage());
        return new ResponseEntity<>(errorDto,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidResourceException.class)
    public ResponseEntity<ErrorDto> handleInvalidResourceException(InvalidResourceException exception) {
        ErrorDto errorDto = new ErrorDto(new Date(),
                ErrorCode.RESOURCE_NOT_VALID, exception.getMessage(),
                exception.getErrors());
        return new ResponseEntity<>(errorDto,HttpStatus.BAD_REQUEST);
    }
}

package com.cleto.cinecartaz.exception;

import com.mongodb.MongoWriteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MongoWriteException.class)
    public ResponseEntity duplicateKeyException(MongoWriteException e){

        Map<String, Object> body = new HashMap<>();
        body.put("description", "Cinema Already Exists");

        return new ResponseEntity<>(body, HttpStatus.CONFLICT);
    }

}

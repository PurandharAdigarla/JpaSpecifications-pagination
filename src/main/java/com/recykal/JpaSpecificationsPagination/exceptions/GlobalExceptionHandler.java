package com.recykal.JpaSpecificationsPagination.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler
{
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<Map<String, Object>> ProductNotFoundExceptionHandler(ProductNotFoundException e)
    {
        Map<String, Object> handler= new HashMap<>();
        handler.put("TimeStamp", LocalDateTime.now());
        handler.put("status", HttpStatus.NOT_FOUND.value());
        handler.put("error", "Not Found");
        handler.put("message", e.getMessage());
        handler.put("path", ServletUriComponentsBuilder.fromCurrentRequest().toUriString());

        return new ResponseEntity<>(handler, HttpStatus.NOT_FOUND);
    }
}

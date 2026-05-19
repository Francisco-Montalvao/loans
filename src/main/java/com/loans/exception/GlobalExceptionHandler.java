package com.loans.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.LocalDateTime;
import java.util.HashMap;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler
    public ResponseEntity<?> handleValidacao (MethodArgumentNotValidException ex){
        Map<String, Object> response = new HashMap<>();
        response.put("status", HttpStatus.BAD_REQUEST.value());
        response.put("timestamp", LocalDateTime.now());
        response.put("mensagem", "Erro de validacao em campos");
        response.put("Erros", ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> {
                    assert error.getDefaultMessage() != null;
                    return Map.of("mensagem", error.getDefaultMessage(), "campo", Objects.requireNonNull(error.getField()));
                })
                .collect(Collectors.toList()));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}

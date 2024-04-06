package com.example.fruit.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandle {

    // Global errors: ( w PlantErrorResponse)
    @ExceptionHandler
    public ResponseEntity<PlantErrorResponse> handleException(Exception exception){
        PlantErrorResponse plantErrorResponse = new PlantErrorResponse(HttpStatus.BAD_REQUEST.value(), exception.getMessage(), LocalDateTime.now());
        log.error("EXCEPTION OCCURED: " + exception.getMessage());  // önemli log, iyi bir alışkanlık olur hiç handle etmediğimiz şeyleri.
        return new ResponseEntity<>(plantErrorResponse, HttpStatus.BAD_REQUEST);
    }

    // Validations:
    @ExceptionHandler
    public ResponseEntity handleBindException(MethodArgumentNotValidException exception){
        List errorList = exception.getBindingResult().getFieldErrors()
                .stream().map(fieldError -> {
                    log.error(fieldError.getField(), fieldError.getDefaultMessage());
                    Map<String, String> errorMap = new HashMap<>();
                    errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());  // bu log olmasa da olur.
                    return errorMap;
                }).collect(Collectors.toList());

        return ResponseEntity.badRequest().body(errorList);
    }

    // PlantException (Return null'dan kurtarmak için kendi Exception 'ım)
    @ExceptionHandler
    public ResponseEntity<PlantErrorResponse> handleException(PlantException plantException){
        PlantErrorResponse plantErrorResponse = new PlantErrorResponse(plantException.getStatus().value(), plantException.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(plantErrorResponse, plantException.getStatus());
    }


}

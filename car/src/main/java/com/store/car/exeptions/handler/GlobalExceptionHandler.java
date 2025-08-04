package com.store.car.exeptions.handler;


import com.store.car.exeptions.custom.EntityNotFoundException;
import com.store.car.exeptions.custom.IllegalArgumentExceptio;
import com.store.car.exeptions.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    // Captura a ResourceNotFoundException
    @ExceptionHandler(IllegalArgumentExceptio.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFound(IllegalArgumentExceptio ex) {
        ErrorResponse errorResponse = new ErrorResponse("Erro de validação", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFound(EntityNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse("Entidade não encontrada", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }


}

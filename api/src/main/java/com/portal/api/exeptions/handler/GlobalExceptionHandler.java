package com.portal.api.exeptions.handler;


import com.portal.api.exeptions.custom.ValidationException;
import com.portal.api.exeptions.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Captura qualquer exceção inesperada e retorna um erro 500
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleInternalServerError(Exception ex) {
        // Criando um erro com código e mensagem detalhada
        ErrorResponse errorResponse = new ErrorResponse(
                "INTERNAL_SERVER_ERROR",
                "Ocorreu um erro inesperado ao processar sua solicitação. Por favor, tente novamente mais tarde."
        );

        // Retorna o erro 500 com a resposta detalhada
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

    // Captura falha ao tentar se comunicar com o servidor remoto
    @ExceptionHandler(HttpServerErrorException.class)
    public ResponseEntity<ErrorResponse> handleHttpServerError(HttpServerErrorException ex) {
        // Mensagem mais amigável sem expor detalhes de URL ou exceção técnica
        ErrorResponse errorResponse = new ErrorResponse(
                "SERVER_COMMUNICATION_ERROR",
                "Estamos enfrentando dificuldades técnicas para processar sua solicitação. Tente novamente em breve."
        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

    // Captura a ValidationException
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(ValidationException ex) {
        ErrorResponse errorResponse = new ErrorResponse("Erro de Validação", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}

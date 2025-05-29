package com.ng.aula.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Bad request = Status Code 400 (HttpStatus contém todos os codigos)
@ResponseStatus(HttpStatus.BAD_REQUEST)
// Aplica interface RuntimeException caso o tempo demore muito, para não ficar em um request
// infinito consumindo dados da API
public class UnsuportedMathOperationException extends RuntimeException {
    // Lança a mensagem de erro
    public UnsuportedMathOperationException(String message) {
        super(message);
    }
}

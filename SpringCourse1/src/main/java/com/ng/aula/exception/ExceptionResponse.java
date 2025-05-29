package com.ng.aula.exception;

import java.util.Date;

// Define pelo record os parametros timestamp, message e details (e já que não vão precisar
// ser alterados futuramente, usamos o record que já faz encapsulamento, getters e setters)
public record ExceptionResponse(Date timestamp, String message, String details) {
}

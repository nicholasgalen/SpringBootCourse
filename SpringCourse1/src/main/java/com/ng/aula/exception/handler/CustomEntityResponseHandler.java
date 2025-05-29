package com.ng.aula.exception.handler;

import com.ng.aula.exception.ExceptionResponse;
import com.ng.aula.exception.UnsuportedMathOperationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice // Vira o tratamento de excessão global para todas as files
// qualquer erro que tiver e não for especificado cai no ControllerAdvice
@RestController
public class CustomEntityResponseHandler extends ResponseEntityExceptionHandler {

    // Essa é uma excessão generica da classe Exception, para excessões genericas
    @ExceptionHandler(Exception.class)
    // Usamos < > em ExceptionResponse (nossa interface/record de erros) são generics.
    // Generics permitem criar classes e métodos com "tipos genéricos", que serão especificados quando usados.
    // eg. Array<String> meuArray = new Array<>();
    // O < > apenas define que tipo valores serão criados a partir do objeto.
    //
    // NO MEU CASO:
    // O < > diz que a resposta HTTP vai conter um objeto do tipo ExceptionResponse no corpo (body).
    // O Spring vai converter esse objeto para JSON automaticamente (por conta do @RestController e da lib Jackson).
    public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request){
        // Cria uma resposta de erro em JSON
        ExceptionResponse response = new ExceptionResponse(
                new Date(), // Data e hora da exceção
                ex.getMessage(), // Mensagem de erro gerada pela exceção
                request.getDescription(false)); // Detalhes da requisição que causou o erro (ex: URI)
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Método que trata exceções específicas da classe UnsuportedMathOperationException
    @ExceptionHandler(UnsuportedMathOperationException.class)
    // O WebRequest que trata de pegar a URI do .getDescription, ele é uma interface do Spring que representa
    // requisições HTTP, contendo header, URI, parametros etc.
    public final ResponseEntity<ExceptionResponse> handleBadRequestExceptions(Exception ex, WebRequest request){
        ExceptionResponse response = new ExceptionResponse(
                new Date(),
                ex.getMessage(),
                request.getDescription(true)); // Pega o request da interface WebRequest que retonra o URI.
        // O false não inclui informações do usuario como IP e metadados. Se for true retorna: "uri=/math/sum/7.9/a;client=(meu IP)"
        // Porém no meu caso (localhost) retorna meu IP de maquina, não meu IP real.

        // Retorna o json response e o status http (nesse caso 400 bad request)
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}

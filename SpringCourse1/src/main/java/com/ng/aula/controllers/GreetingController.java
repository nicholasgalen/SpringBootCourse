package com.ng.aula.controllers;

import com.ng.aula.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

// RestController é um @ que contém 2 @s, o @Controller e o @ResponseBody
// ele é uma forma simplificada para declarar que essa classe é um controle
// de requisições http e sempre vai retornar o body sem precisar declarar toda vez
@RestController
public class GreetingController {

    // template da string que vai aparecer na tela
    private static final String template = "Hello %s";

    // AtomicLong vem do pacote java.util.concurrent.atomic
    // Ele é thread-safe (acesso controlado pelos nucleos para evitar corromper)
    // É muito usado para gerar IDs temporarios e contar chamadas de API
    private final AtomicLong counter = new AtomicLong();

    // aparece no dominio/greeting (também pode ser usado @GetMapping, mas muitos
    // codigos legados ainda usam @RequestMapping)
    @RequestMapping("/greeting")
    public Greeting greeting(
            // pega o parametro name, /greeting?name=teste (Hello teste)
            // caso entre só em /greeting vai aparecer (Hello World) TEMPLATE
            @RequestParam(value = "name", defaultValue = "World")
            String name){
        // retorna a String Hello (var) e incrementa automaticamente o ID com incrementAndGet()
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}

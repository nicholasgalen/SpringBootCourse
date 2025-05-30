package com.ng.aula.controllers;

import com.ng.aula.PersonServices;
import com.ng.aula.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    // DI (dependency injection)
    @Autowired // Autowired já faz a injeção de dependencia direto para a gente (obrigado Spring [= )
    private PersonServices service; // private PersonServices service = new PersonServices();

    // Se não inserirmos o value ele sempre vai usar esse metodo no /person como método padrão
    @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Person> findAll(){
        return service.findAll();
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET, // é bom porque garante que apenas requisições GET são aceitas nesse endpoint
            produces = MediaType.APPLICATION_JSON_VALUE // apenas especifica que esse endpoint retorna JSON
    )
    public Person findById(@PathVariable("id") String id){
        return service.findById(id);
    }
}

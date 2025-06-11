package com.ng.aula.controllers;

import com.ng.aula.services.PersonServices;
import com.ng.aula.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(
            method = RequestMethod.POST, // é bom porque garante que apenas requisições POST são aceitas nesse endpoint
            produces = MediaType.APPLICATION_JSON_VALUE, // apenas especifica que esse endpoint retorna JSON
            consumes = MediaType.APPLICATION_JSON_VALUE // apenas especifica que esse endpoint CONSOME JSON
            // eles não são nescessarios para funcionar, mas são bons para criar documentação via SWAGGER depois
    )
    // precisamos usar o RequestBody para receber os valores retornados pelo body do json
    // caso contrario, o POST vai retornar TUDO null
    // O RequestBody basicamente pede para o Java converter o JSON para um objeto JAVA (person nesse caso)
    public Person create(@RequestBody Person person){
        return service.create(person);
    }

    @RequestMapping(
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Person update(@RequestBody Person person){
        return service.update(person);
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE
            // não tem media tipe pois não consome nem escreve JSON nem nada do tipo!
    )
    public void delete(@PathVariable("id") String id){
        service.delete(id);
    }
}

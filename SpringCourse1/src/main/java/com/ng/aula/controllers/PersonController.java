package com.ng.aula.controllers;

import com.ng.aula.services.PersonServices;
import com.ng.aula.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    // DI (dependency injection)
    @Autowired // Autowired já faz a injeção de dependencia direto para a gente (obrigado Spring [= )
    private PersonServices service; // private PersonServices service = new PersonServices();

    // Se não inserirmos o value ele sempre vai usar esse metodo no /person como método padrão

    /* @RequestMapping(method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE - é bom porque garante que apenas requisições GET são aceitas nesse endpoint
    )
    public List<Person> findAll(){
        return service.findAll();
    } */

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE) // GetMapping não nescessita do RequestMethod já que ele JÁ
    // TEM essa função implicita dentro dele
    public List<Person> findAll(){
        return service.findAll();
    }

    @GetMapping(
            value = "/{id}" , produces = MediaType.APPLICATION_JSON_VALUE // apenas especifica que esse endpoint retorna JSON
    )
    public Person findById(@PathVariable("id") Long id){
        return service.findById(id);
    }

    // Usamos PostMapping (Literalmente o RequestMapping mas com os padrões Post já definidos)
    @PostMapping(
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

    @PutMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Person update(@RequestBody Person person){
        return service.update(person);
    }

    @DeleteMapping(value = "/{id}"
            // Não precisa de media type pois não envia nem recebe corpo JSON
    )
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        service.delete(id);

        // ResponseEntity permite controlar o status HTTP da resposta e o corpo (se houver)
        // Aqui usamos noContent() que gera um status 204 No Content,
        // que significa "requisição sucedida, mas sem conteúdo para retornar"
        // Se fosse só void, o Spring assumiria 200 OK por padrão.

        // O <?> é um coringa de generics, quer dizer que o corpo da resposta
        // pode ser de qualquer tipo, ou vazio (no caso, sem corpo).
        return ResponseEntity.noContent().build();
    }
}

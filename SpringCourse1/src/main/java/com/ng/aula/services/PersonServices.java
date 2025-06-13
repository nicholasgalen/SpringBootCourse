package com.ng.aula.services;

import com.ng.aula.exception.ResourseNotFoundException;
import com.ng.aula.model.Person;
import com.ng.aula.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service // Serviço para ficar disponivel e ser injetado aonde for preciso (tipo RestController)
public class PersonServices {
    private final AtomicLong counter = new AtomicLong(); // AtomicLong é uma classe do pacote java.util.concurrent.atomic
    // usada para operações seguras em múltiplas threads com variáveis do tipo long. Começa em 0 (padrão).
    // Pode ser acessado e modificado de forma segura em ambientes concorrentes, sem a necessidade de usar synchronized ou locks.
    private Logger logger = LoggerFactory.getLogger(PersonServices.class.getName()); // loggers são bons para mostrar:
    // Informações, Erros, Avisos e Depuração da API via logs, bom para DEBUG.

    // Usando DI com nosso Repository
    @Autowired
    PersonRepository repository;

    public List<Person> findAll(){
        // List<Person> persons = new ArrayList<Person>();

        /* list mock!
        for (int i = 0; i < 8; i++){
            Person person = mockPerson(i);
            persons.add(person);
        } */

        logger.info("Finding all persons.");
        return repository.findAll(); // metodo findAll está incluso no jakarta.jparepository, fazer o "list mock"
    }

    public Person findById(Long id){ // Eu poderia usar Optional<Person> para tratar o erro, mas estamos usando a função
        // lambda como foi feito no curso
        logger.info("Finding one Person.");

        /* mock test
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Nicholas");
        person.setLastName("Galen");
        person.setAddress("Waterloo - Ontario - Canadá");
        person.setGender('M');*/

        // Aqui usamos a função lambda para tratar quando o ID não existir. Ele vai lançar forçadamente esse erro do
        // ResourseNotFoundException (que nós mesmos criamos)
        return repository.findById(id).orElseThrow(() -> new ResourseNotFoundException("No records found for this ID."));
    }

    public Person create(Person person){
        logger.info("Creating Person.");
        return repository.save(person);
    }

    public Person update(Person person){
        logger.info("Updating Person.");

        // a gente cria um novo updatedPerson para salvar o update que fizemos no metodo updatePerson para evitar
        // corromper ou o JPA não gerenciar
        Person updatedPerson = updatePerson(person);

        return repository.save(updatedPerson);
    }

    public void delete(Long id){ // DELETE pode ser void, já que não precisa retornar nada, só a deleção do objeto
        logger.info("Deleting Person.");
        Person entity = repository.findById(id).orElseThrow(() -> new ResourseNotFoundException("No records found for this ID."));

        repository.delete(entity);
    }

    /* mocker!
    private Person mockPerson(int i){
        logger.info("Finding all Persons.");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person " + i);
        person.setLastName("Lastname " + i);
        person.setAddress("Waterloo - Ontario - Canadá");
        person.setGender('M');
        return person;
    }*/

    private Person updatePerson(Person person){
        logger.info("Updating person.");

        Person entity = repository.findById(person.getId()).orElseThrow(() -> new ResourseNotFoundException("No records found for this ID."));

        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return entity;
    }
}

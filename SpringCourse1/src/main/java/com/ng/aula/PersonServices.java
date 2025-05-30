package com.ng.aula;

import com.ng.aula.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service // Serviço para ficar disponivel e ser injetado aonde for preciso (tipo RestController)
public class PersonServices {
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName()); // loggers são bons para mostrar:
    // Informações, Erros, Avisos e Depuração da API via logs, bom para DEBUG.

    public List<Person> findAll(){
        List<Person> persons = new ArrayList<Person>();

        // list mock!
        for (int i = 0; i < 8; i++){
            Person person = mockPerson(i);
            persons.add(person);
        }

        return persons;
    }

    public Person findById(String id){
        logger.info("Finding one Person.");

        // mock test
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Nicholas");
        person.setLastName("Galen");
        person.setAddress("Waterloo - Ontario - Canadá");
        person.setGender('M');
        return person;
    }

    public Person create(Person person){
        logger.info("Creating Person.");
        return person;
    }

    public Person update(Person person){
        logger.info("Updating Person.");
        return person;
    }

    public void delete(String id){ // DELETE pode ser void, já que não precisa retornar nada, só a deleção do objeto
        logger.info("Deleting Person.");
    }

    // mocker!
    private Person mockPerson(int i){
        logger.info("Finding all Persons.");

        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person " + i);
        person.setLastName("Lastname " + i);
        person.setAddress("Waterloo - Ontario - Canadá");
        person.setGender('M');
        return person;
    }
}

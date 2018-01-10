package com.por.belajarspringboot.controller;

import com.por.belajarspringboot.entity.Person;
import com.por.belajarspringboot.request.SavePersonRequest;
import com.por.belajarspringboot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping(
            value = "/person",
            produces = MediaType.APPLICATION_JSON_VALUE, //ACCEPT
            consumes = MediaType.APPLICATION_JSON_VALUE //CONTENT-TYPE
    )
    public Person savePerson(@Valid @RequestBody SavePersonRequest request){
        return personService.savePerson(request);
    }

    @GetMapping(
            value = "/person",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Person> getAllPerson(){
        return personService.getAllPerson();
    }

    @GetMapping(
            value = "/person/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Person getOnePerson(@PathVariable("id") Long id){
        return personService.getPersonById(id);
    }

    @DeleteMapping(
            value = "/person/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public void deletePerson(@PathVariable("id") Long id){
        personService.deletePersonById(id);
    }

    @PutMapping(
            value = "/person/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Person updatePerson(@PathVariable("id") Long id,
                               @Valid @RequestBody SavePersonRequest request){
        return personService.updatePerson(id, request);
    }

}

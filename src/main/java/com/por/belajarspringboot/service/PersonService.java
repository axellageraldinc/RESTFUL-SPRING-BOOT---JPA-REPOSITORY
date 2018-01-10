package com.por.belajarspringboot.service;

import com.por.belajarspringboot.entity.Person;
import com.por.belajarspringboot.request.SavePersonRequest;

import java.util.List;

public interface PersonService {

    Person savePerson(SavePersonRequest request);
    List<Person> getAllPerson();
    Person getPersonById(Long id);
    void deletePersonById(Long id);
    Person updatePerson(Long id, SavePersonRequest request);

}

package com.por.belajarspringboot.service;

import com.por.belajarspringboot.entity.Person;

import java.util.List;

public interface PersonService {

    Person savePerson(Person person);
    List<Person> getAllPerson();
    Person getPersonById(Long id);
    void deletePersonById(Long id);
    Person updatePerson(Person person);

}

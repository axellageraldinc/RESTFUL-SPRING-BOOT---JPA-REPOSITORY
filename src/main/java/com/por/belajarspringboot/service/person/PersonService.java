package com.por.belajarspringboot.service.person;

import com.por.belajarspringboot.entity.Person;
import com.por.belajarspringboot.request.SavePersonRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PersonService {

    Person savePerson(SavePersonRequest request);
    Page<Person> getAllPerson(int pageNumber);
    Person getPersonById(Long id);
    Person deletePersonById(Long id);
    Person updatePerson(Long id, SavePersonRequest request);

}

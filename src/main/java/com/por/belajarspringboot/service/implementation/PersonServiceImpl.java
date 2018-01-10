package com.por.belajarspringboot.service.implementation;

import com.por.belajarspringboot.entity.Person;
import com.por.belajarspringboot.repository.PersonRepository;
import com.por.belajarspringboot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    @Transactional
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }

    @Override
    public Person getPersonById(Long id) {
        return personRepository.findOne(id);
    }

    @Override
    public void deletePersonById(Long id) {
        personRepository.delete(id);
    }

    @Override
    public Person updatePerson(Person person) {
        return personRepository.save(person);
    }
}

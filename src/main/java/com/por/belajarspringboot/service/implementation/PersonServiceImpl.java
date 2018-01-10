package com.por.belajarspringboot.service.implementation;

import com.por.belajarspringboot.entity.Person;
import com.por.belajarspringboot.repository.PersonRepository;
import com.por.belajarspringboot.request.SavePersonRequest;
import com.por.belajarspringboot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional //supaya kalau ada pengubahan data di database yg gagal, akan rollback
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person savePerson(SavePersonRequest request) {
        Person person = new Person(request.getName(), request.getAge(), request.getAddress());
        return personRepository.save(person);
    }

    //Gak terlalu butuh transactional karena kan gak ada perubahan data di database, jadi gak terlalu butuh transactional
    @Transactional(readOnly = true)
    @Override
    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Person getPersonById(Long id) {
        return personRepository.findOne(id);
    }

    @Override
    public void deletePersonById(Long id) {
        personRepository.delete(id);
    }

    @Override
    public Person updatePerson(Long id, SavePersonRequest request) {
        Person person = personRepository.findOne(id);
        person.setName(request.getName());
        person.setAge(request.getAge());
        person.setAddress(request.getAddress());
        return personRepository.save(person);
    }
}

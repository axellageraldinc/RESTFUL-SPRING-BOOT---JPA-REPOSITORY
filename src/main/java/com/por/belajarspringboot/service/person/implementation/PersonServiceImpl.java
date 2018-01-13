package com.por.belajarspringboot.service.person.implementation;

import com.por.belajarspringboot.entity.Person;
import com.por.belajarspringboot.repository.PersonRepository;
import com.por.belajarspringboot.request.SavePersonRequest;
import com.por.belajarspringboot.service.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional //supaya kalau ada pengubahan data di database yg gagal, akan rollback
public class PersonServiceImpl implements PersonService {

    private static final int PAGE_SIZE = 3;

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
    public Page<Person> getAllPerson(int pageNumber) {
        Sort sort = new Sort(new Sort.Order(Sort.Direction.ASC, "name"));
        Pageable pageable = new PageRequest(pageNumber-1, PAGE_SIZE, sort);
//        PageRequest pageRequest = new PageRequest(pageNumber-1, PAGE_SIZE, Sort.Direction.ASC, "name"); //sort ASC berdasarkan nama
        return personRepository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    @Override
    public Person getPersonById(Long id) {
        return personRepository.findOne(id);
    }

    @Override
    public Person deletePersonById(Long id) {
        Person person = personRepository.findOne(id);
        if(person!=null){
            personRepository.delete(id);
        }
        return person;
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

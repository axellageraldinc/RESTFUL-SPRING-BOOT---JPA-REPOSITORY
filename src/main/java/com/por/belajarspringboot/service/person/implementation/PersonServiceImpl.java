package com.por.belajarspringboot.service.person.implementation;

import com.por.belajarspringboot.entity.Person;
import com.por.belajarspringboot.helper.mapper.PersonMapper;
import com.por.belajarspringboot.repository.PersonRepository;
import com.por.belajarspringboot.request.SavePersonRequest;
import com.por.belajarspringboot.response.WebResponse;
import com.por.belajarspringboot.response.person.PersonResponse;
import com.por.belajarspringboot.service.person.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional //supaya kalau ada pengubahan data di database yg gagal, akan rollback
public class PersonServiceImpl implements PersonService {

    private static final int PAGE_SIZE = 3;

    @Autowired
    private PersonRepository personRepository;

    @Override
    public WebResponse<PersonResponse> savePerson(SavePersonRequest request) {
        Person person = PersonMapper.personRequestToPerson(request);
        PersonResponse personResponse = PersonMapper.personToPersonResponse(personRepository.save(person));
        return WebResponse.OK(personResponse);
    }

    //Gak terlalu butuh transactional karena kan gak ada perubahan data di database, jadi gak terlalu butuh transactional
    @Transactional(readOnly = true)
    @Override
    public WebResponse<Page<PersonResponse>> getAllPerson(int pageNumber) {
        Sort sort = new Sort(new Sort.Order(Sort.Direction.ASC, "name"));
        Pageable pageable = new PageRequest(pageNumber-1, PAGE_SIZE, sort);
        Page<Person> personPage = personRepository.findAll(pageable);
        Page<PersonResponse> personResponsePage = PersonMapper.personPageToPersonResponsePage(pageable, personPage);
        return WebResponse.OK(personResponsePage);
    }

    @Transactional(readOnly = true)
    @Override
    public WebResponse<PersonResponse> getPersonById(Long id) {
        Person person = personRepository.findOne(id);
        if(person == null){
            return WebResponse.NOT_FOUND();
        } else {
            return WebResponse.OK(PersonMapper.personToPersonResponse(person));
        }
    }

    @Override
    public WebResponse<PersonResponse> deletePersonById(Long id) {
        Person person = personRepository.findOne(id);
        if(person == null){
            return WebResponse.NOT_FOUND();
        } else {
            personRepository.delete(id);
            return WebResponse.OK(PersonMapper.personToPersonResponse(person));
        }
    }

    @Override
    public WebResponse<PersonResponse> updatePerson(Long id, SavePersonRequest request) {
        Person person = personRepository.findOne(id);
        if(person == null){
            return WebResponse.NOT_FOUND();
        } else {
            person = PersonMapper.personRequestToPerson(request);
            person.setId(id);
            PersonResponse personResponse = PersonMapper.personToPersonResponse(personRepository.save(person));
            return WebResponse.OK(personResponse);
        }
    }

}

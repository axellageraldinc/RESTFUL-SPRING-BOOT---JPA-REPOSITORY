package com.por.belajarspringboot.service.person;

import com.por.belajarspringboot.entity.Person;
import com.por.belajarspringboot.request.SavePersonRequest;
import com.por.belajarspringboot.response.WebResponse;
import com.por.belajarspringboot.response.person.PersonResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PersonService {

    WebResponse<PersonResponse> savePerson(SavePersonRequest request);
    WebResponse<Page<PersonResponse>> getAllPerson(int pageNumber);
    WebResponse<PersonResponse> getPersonById(Long id);
    WebResponse<PersonResponse> deletePersonById(Long id);
    WebResponse<PersonResponse> updatePerson(Long id, SavePersonRequest request);

}

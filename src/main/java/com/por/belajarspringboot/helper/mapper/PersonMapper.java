package com.por.belajarspringboot.helper.mapper;

import com.por.belajarspringboot.entity.Person;
import com.por.belajarspringboot.request.SavePersonRequest;
import com.por.belajarspringboot.response.person.PersonResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 *
 * Class untuk mapping (CONVERT) :
 *                                  1. Dari entity Person ke PersonResponse
 *                                  2. Dari SavePersonRequest ke Person
 *                                  3. Dari PersonList ke PersonResponseList
 *                                  4. Dari PersonPage ke PersonResponsePage
 *
 * Ini dilakukan karena BEST PRACTICE-nya seperti itu.
 * Tidak boleh secara utuh melempar entity menjadi response. Kenapa?
 * Karena bisa jadi di entity Person itu ada field password (meskipun disini gak ada), nah masa ya password mau dilempar jadi response kan bahaya.
 * Makannya ada personResponse itu nanti gunanya untuk melempar field-field yang patut dilempar ke response saja (gak semuanya)
 *
 *
**/

public class PersonMapper {

    public static PersonResponse personToPersonResponse(Person person){
        PersonResponse personResponse = PersonResponse.builder()
                .name(person.getName())
                .age(person.getAge())
                .address(person.getAddress())
                .build();
        return personResponse;
    }

    public static List<PersonResponse> personListToPersonResponseList(List<Person> personList){
        return personList.stream()
                .map(PersonMapper::personToPersonResponse)
                .collect(Collectors.toList());
    }

    public static Page<PersonResponse> personPageToPersonResponsePage(Pageable pageable,
                                                                      Page<Person> personPage){
        List<PersonResponse> personList = personListToPersonResponseList(personPage.getContent());
        return new PageImpl<>(personList, pageable, personPage.getTotalElements());
    }

    public static Person personRequestToPerson(SavePersonRequest request){
        Person person = Person.builder()
                .name(request.getName())
                .age(request.getAge())
                .address(request.getAddress())
                .build();
        return person;
    }

}

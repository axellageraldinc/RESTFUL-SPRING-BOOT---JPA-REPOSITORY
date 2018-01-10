package com.por.belajarspringboot.controller;

import com.por.belajarspringboot.entity.Person;
import com.por.belajarspringboot.request.SavePersonRequest;
import com.por.belajarspringboot.service.person.PersonService;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PersonControllerTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    PersonService personService;

    @InjectMocks
    PersonController personController;

    @Test
    public void savePerson_ReturnSuccess(){
        Mockito.when(personService.savePerson(Mockito.any(SavePersonRequest.class)))
                .then(invocation -> invocation.getArguments()[0]);

        Person person = personController.savePerson(new SavePersonRequest("Axell", 20, "Yogyakarta"));

        assertEquals("Axell", person.getName());
        assertEquals(20, person.getAge());
        assertEquals("Yogyakarta", person.getAddress());

        Mockito.verify(personService, Mockito.times(1)).savePerson(Mockito.any(SavePersonRequest.class));

    }

    @Test
    public void getAllPerson_ReturnSuccess(){
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Axell", 20, "Yogyakarta"));
        Mockito.when(personService.getAllPerson()).thenReturn(personList);

        personList = personController.getAllPerson();

        assertNotNull(personList);
        assertEquals(personList.isEmpty(), false);
    }

}
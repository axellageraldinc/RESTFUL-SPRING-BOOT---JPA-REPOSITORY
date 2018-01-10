package com.por.belajarspringboot.service.implementation;

import com.por.belajarspringboot.entity.Person;
import com.por.belajarspringboot.repository.PersonRepository;
import com.por.belajarspringboot.request.SavePersonRequest;
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

public class PersonServiceImplTest {

    /*
    * rule ini untuk aturan unit test-nya... jadi membaca semua attribute Mock dan InjectMock
    */
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    /*
    * rule ini untuk aturan unit test-nya... jadi membaca semua attribute Mock dan InjectMock
    */
    @Mock
    private PersonRepository personRepository;

    /*
    * rule ini untuk aturan unit test-nya... jadi membaca semua attribute Mock dan InjectMock
    */
    @InjectMocks
    private PersonServiceImpl personService;

    @Test
    public void savePerson_ReturnSuccess(){

        /*
        * Ketika memanggil personRepository.save dengan anyObject yg nilainya sembarang yg penting person.class,
        * maka akan meng-get argumen pertama (yaitu isinya sama dengan Person.class) tadi.
        * Intinya disamakan antara argumen Person yg di-insert dengan yang di-return
        * */
        Mockito.when(personRepository.save(Mockito.any(Person.class)))
                .then(invocation -> invocation.getArguments()[0]);

        Person person = personService.savePerson(new SavePersonRequest("Axell", 20, "Yogyakarta"));

        assertEquals("Axell", person.getName());
        assertEquals(20, person.getAge());
        assertEquals("Yogyakarta", person.getAddress());

        /*
        * Memastikan bahwa personRepository beneran dipanggil dan hanya dipanggil sekali saja
        */
        Mockito.verify(personRepository, Mockito.times(1))
                .save(Mockito.any(Person.class));
    }

    @Test(expected = RuntimeException.class)
    public void savePerson_ReturnFailed(){
        Mockito.when(personRepository.save(Mockito.any(Person.class))).thenThrow(new RuntimeException());

        personService.savePerson(new SavePersonRequest("Axell", 20, "Yogyakarta"));

    }

    @Test
    public void getAll_ReturnSuccess(){
        Mockito.when(personRepository.findAll()).thenReturn(Mockito.anyListOf(Person.class));

        List<Person> personList = personService.getAllPerson();

        assertNotNull(personList);
        assertEquals(personList.isEmpty(), false);

        Mockito.verify(personRepository, Mockito.times(1))
                .findAll();
    }

}
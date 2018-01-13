package com.por.belajarspringboot.service.person.implementation;

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

        Person person;

        person = personService.savePerson(
                new SavePersonRequest(
                        "Axell",
                        20,
                        "Yogyakarta"));

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
        List<Person> personList = new ArrayList<>();

        personList.add(new Person("Axell", 20, "Yogyakarta"));

        Mockito.when(personRepository.findAll()).thenReturn(personList);

//        List<Person> personFromDb = personService.getAllPerson(1);

        assertNotNull(personList);
        assertEquals(personList.isEmpty(), false);
//        assertEquals(personList, personFromDb);

        Mockito.verify(personRepository, Mockito.times(1))
                .findAll();
    }

    @Test
    public void getPersonById_ReturnSuccess(){

        Person person = new Person();
        person.setId(1L);
        person.setName("Axell");
        person.setAddress("Yogyakarta");

        Mockito.when(personRepository.findOne(1L)).thenReturn(person);

        Person personFromDb = personService.getPersonById(1L);

        assertEquals(person, personFromDb);

        Mockito.verify(personRepository, Mockito.times(1)).findOne(1L);
    }


}
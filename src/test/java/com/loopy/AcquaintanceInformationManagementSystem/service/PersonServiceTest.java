package com.loopy.AcquaintanceInformationManagementSystem.service;

import com.loopy.AcquaintanceInformationManagementSystem.domain.Block;
import com.loopy.AcquaintanceInformationManagementSystem.domain.Person;
import com.loopy.AcquaintanceInformationManagementSystem.repository.BlockRepository;
import com.loopy.AcquaintanceInformationManagementSystem.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class PersonServiceTest {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private BlockRepository blockRepository;
    @Autowired
    private PersonService personService;

    @Test
    void getPeopleExcludeBlockList(){
        givenPeople();

        List<Person> result = personService.getPeopleExcludeBlockList();
        //System.out.println(result);
        result.forEach(System.out::println);
    }

    @Test
    void getPeopleByName(){
        givenPeople();

        List<Person> result = personService.getPeopleByName("martin");

        result.forEach(System.out::println);
    }

    @Test
    void cascadeTest(){

        givenPeople();

        List<Person> result = personRepository.findAll();
        result.forEach(System.out::println);

        Person person = result.get(1);
        person.getBlock().setStartTime(LocalDateTime.now());
        person.getBlock().setEndTime(LocalDateTime.now());

        personRepository.save(person);
        personRepository.findAll().forEach(System.out::println);
/*
        personRepository.delete(person);
        personRepository.findAll().forEach(System.out::println);
        blockRepository.findAll().forEach(System.out::println);

 */
        person.setBlock(null);
        personRepository.save(person);
        personRepository.findAll().forEach(System.out::println);
        blockRepository.findAll().forEach(System.out::println);

    }

    @Test
    void getPerson(){
        givenPeople();

        Person person = personService.getPerson(1L);
    }

    private void givenPeople() {
        givenPerson("martin", 27,"A");
        givenBlockPerson("jenny", 25,"A");
        givenPerson("mike", 22,"A");
        givenBlockPerson("hey", 21,"A");
    }

    private void givenBlockPerson(String name, int age, String bloodType) {
        Person person = new Person(name, age, bloodType);
        person.setBlock(new Block(name));
        personRepository.save(person);
    }

    private void givenPerson(String name, int age, String bloodType) {
        personRepository.save(new Person(name,age,bloodType));
    }


}
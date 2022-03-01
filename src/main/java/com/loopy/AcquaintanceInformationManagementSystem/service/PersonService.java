package com.loopy.AcquaintanceInformationManagementSystem.service;

import com.loopy.AcquaintanceInformationManagementSystem.domain.Block;
import com.loopy.AcquaintanceInformationManagementSystem.domain.Person;
import com.loopy.AcquaintanceInformationManagementSystem.repository.BlockRepository;
import com.loopy.AcquaintanceInformationManagementSystem.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> getPeopleExcludeBlockList(){
/*
        List<Person> people = personRepository.findAll();

        return people.stream().filter(person -> person.getBlock()==null).collect(Collectors.toList());

 */
        return personRepository.findByBlockIsNull();
    }

    @Transactional(readOnly = true)
    public Person getPerson(Long id){
        Person person = personRepository.findById(id).orElse(null);



        log.info("person : {}", person);
        return person;
    }


    public List<Person> getPeopleByName(String name) {
        /*
        List<Person> people = personRepository.findAll();

        return people.stream().filter(person-> person.getName().equals(name)).collect(Collectors.toList());

         */

        return personRepository.findByName(name);
    }

    @Transactional
    public void save(Person person) {
        personRepository.save(person);
    }
}

package com.loopy.AcquaintanceInformationManagementSystem.service;

import com.loopy.AcquaintanceInformationManagementSystem.domain.Person;
import com.loopy.AcquaintanceInformationManagementSystem.domain.dto.Birthday;
import com.loopy.AcquaintanceInformationManagementSystem.domain.dto.PersonDto;
import com.loopy.AcquaintanceInformationManagementSystem.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Transactional
    public void update(Long id, PersonDto dto) {

        Person personInDb = personRepository.findById(id).orElseThrow(()-> new RuntimeException("아이디가 존재하지 않습니다."));

        if(!personInDb.getName().equals(dto.getName())){
            throw new RuntimeException("이름이 다릅니다.");
        }

        personInDb.set(dto);
        personRepository.save(personInDb);
    }

    @Transactional
    public void update(Long id, String name) {

        Person person = personRepository.findById(id).orElseThrow(()->new RuntimeException("아이디가 존재하지 않습니다."));

        person.setName(name);

        personRepository.save(person);
    }
}

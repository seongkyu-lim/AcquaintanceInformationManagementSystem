package com.loopy.AcquaintanceInformationManagementSystem.controller;

import com.loopy.AcquaintanceInformationManagementSystem.domain.Person;
import com.loopy.AcquaintanceInformationManagementSystem.domain.dto.PersonDto;
import com.loopy.AcquaintanceInformationManagementSystem.repository.PersonRepository;
import com.loopy.AcquaintanceInformationManagementSystem.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/person")
@Slf4j
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/{id}")
    public Person getPerson(@PathVariable Long id){
        return personService.getPerson(id);
    }

    @PostMapping
    public void postPerson(@RequestBody Person person){
        personService.save(person);

        log.info("person -> {} ", personRepository.findAll());
    }

    @PutMapping("/{id}")
    //@RequestParam을 해주지 않아도 default로 id는 requestparam으로 받음.
    public void updatePerson(@PathVariable Long id, @RequestBody PersonDto dto){
        personService.update(id, dto);

        log.info("person -> {}", personRepository.findAll());
    }

    @PatchMapping("/{id}")
    public void updatePerson(@PathVariable Long id, String name){
        personService.update(id, name);

        log.info("person -> {}", personRepository.findAll());
    }


    @DeleteMapping("/{id}")
    public void deletePerson(@PathVariable Long id) {

        personService.delete(id);

        log.info("person -> {}",personRepository.findAll());

    }
}

package com.loopy.AcquaintanceInformationManagementSystem.service;

import com.loopy.AcquaintanceInformationManagementSystem.domain.Block;
import com.loopy.AcquaintanceInformationManagementSystem.domain.Person;
import com.loopy.AcquaintanceInformationManagementSystem.repository.BlockRepository;
import com.loopy.AcquaintanceInformationManagementSystem.repository.PersonRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

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
    @DisplayName("블락되않은 사람들만을 조회할 수 있다.")
    void getPeopleExcludeBlockList(){
        List<Person> result = personService.getPeopleExcludeBlockList();

        assertThat(result.get(0).getName()).isEqualTo("martin");
        assertThat(result.get(1).getName()).isEqualTo("jake");

    }

    @Test
    @DisplayName("이름으로 정보를 조회할 수 있다.")
    void getPeopleByName(){
        List<Person> result = personService.getPeopleByName("martin");

        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getName()).isEqualTo("martin");
    }

    @Test
    @DisplayName("id로 사람 찾기.")
    void getPerson(){
        Person person = personService.getPerson(1L);

        assertThat(person.getName()).isEqualTo("martin");
    }

    @Test
    @DisplayName("cascade 원리 파악하기.")
    void cascadeTest() {
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
}
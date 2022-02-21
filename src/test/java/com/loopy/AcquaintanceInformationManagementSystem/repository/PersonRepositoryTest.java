package com.loopy.AcquaintanceInformationManagementSystem.repository;

import com.loopy.AcquaintanceInformationManagementSystem.domain.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    @Test
    void crud(){

        Person person = new Person();
        person.setAge(15);
        person.setName("jane");

        personRepository.save(person);

        // .findAll()을하면 저장된 데이터들을 리스트형식으로 전부 반환.
        System.out.println(personRepository.findAll());

        List<Person> people = personRepository.findAll();

        assertThat(people.size()).isEqualTo(1);
        assertThat(people.get(0).getAge()).isEqualTo(15);
        assertThat(people.get(0).getName()).isEqualTo("jane");
    }

    @Test
    void hashcodeAndEquals(){

        Person person1 = new Person("martin", 19);
        Person person2 = new Person("martin", 19);

        System.out.println(person1.equals(person2));
        System.out.println(person1.hashCode());
        System.out.println(person2.hashCode());


    }

}
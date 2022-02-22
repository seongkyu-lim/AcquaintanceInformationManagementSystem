package com.loopy.AcquaintanceInformationManagementSystem.repository;

import com.loopy.AcquaintanceInformationManagementSystem.domain.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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

        Person person1 = new Person("martin", 19, "A");
        Person person2 = new Person("martin", 19,"A");

        System.out.println(person1.equals(person2));
        System.out.println(person1.hashCode());
        System.out.println(person2.hashCode());


    }

    @Test
    void findByBloodType(){

        givenPerson("david", 20, "A");
        givenPerson("HEY", 23, "A");
        givenPerson("jane", 12, "B");
        givenPerson("sophia", 13, "AB");

        List<Person> result = personRepository.findByBloodType("A");
        result.forEach(System.out::println);
    }

    @Test
    void findByBirthdayBetween(){

        givenPerson("david", 20, "A", LocalDateTime.of(1991,9,12,12,12));
        givenPerson("HEY", 23, "A",LocalDateTime.of(1991,10,12,12,12));
        givenPerson("jane", 12, "B",LocalDateTime.of(1990,9,12,12,12));
        givenPerson("sophia", 13, "AB",LocalDateTime.of(1990,2,12,12,12));

        List<Person> result = personRepository.findByBirthdayBetween(LocalDateTime.of(1991,8,2,12,12), LocalDateTime.of(1992,9,3,12,12));

        result.forEach(System.out::println);
    }

    private void givenPerson(String name, int age, String bloodType){

        givenPerson(name, age, bloodType, null);

    }

    private void givenPerson(String name, int age, String bloodType, LocalDateTime birthDay){

        Person person = new Person(name, age, bloodType);
        person.setBirthday(birthDay);
        personRepository.save(person);

    }

}
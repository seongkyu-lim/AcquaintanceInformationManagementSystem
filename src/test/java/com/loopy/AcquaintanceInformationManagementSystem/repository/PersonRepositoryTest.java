package com.loopy.AcquaintanceInformationManagementSystem.repository;

import com.loopy.AcquaintanceInformationManagementSystem.domain.Person;
import com.loopy.AcquaintanceInformationManagementSystem.domain.dto.Birthday;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
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

        givenPerson("david", 20, "A", LocalDate.of(1991,2,28));
        givenPerson("HEY", 23, "A",LocalDate.of(1991,10,12));
        givenPerson("jane", 12, "B",LocalDate.of(1990,9,12));
        givenPerson("sophia", 13, "AB",LocalDate.of(1990,2,12));

        List<Person> result = personRepository.findByMonthOfBirthday(9);

        result.forEach(System.out::println);
    }


    //overloading
    private void givenPerson(String name, int age, String bloodType){

        givenPerson(name, age, bloodType, null);

    }

    private void givenPerson(String name, int age, String bloodType, LocalDate birthDay){

        Person person = new Person(name, age, bloodType);
        person.setBirthday(new Birthday(birthDay));
        personRepository.save(person);

    }

}
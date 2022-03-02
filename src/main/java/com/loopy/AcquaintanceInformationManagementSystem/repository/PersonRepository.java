package com.loopy.AcquaintanceInformationManagementSystem.repository;

import com.loopy.AcquaintanceInformationManagementSystem.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByName(String name);

    List<Person> findByBlockIsNull();

    List<Person> findByBloodType(String bloodType);

    //JPQL
    @Query(value = "select person from Person person where person.birthday.monthOfBirthday= :month")
    List<Person> findByMonthOfBirthday(@Param("month") int month);


    //nativeQuery 옵션을 true로 하면 entity와 상관없이 jpql문만 실행한다.
    // nativeQuery 옵션을 사용하지않으면 person entity에 deleted false인 것만 조회하여 조회가안됨.
    @Query(value = "select person from Person person where person.deleted = true", nativeQuery = true)
    List<Person> findByPeopleDeleted();

}

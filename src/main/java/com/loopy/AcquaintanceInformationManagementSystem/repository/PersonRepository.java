package com.loopy.AcquaintanceInformationManagementSystem.repository;

import com.loopy.AcquaintanceInformationManagementSystem.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByName(String name);

    List<Person> findByBlockIsNull();

    List<Person> findByBloodType(String bloodType);

    List<Person> findByBirthdayBetween(LocalDateTime startDate, LocalDateTime endDate);
}

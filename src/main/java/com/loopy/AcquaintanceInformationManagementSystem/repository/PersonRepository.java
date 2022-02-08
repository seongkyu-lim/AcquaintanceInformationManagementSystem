package com.loopy.AcquaintanceInformationManagementSystem.repository;

import com.loopy.AcquaintanceInformationManagementSystem.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}

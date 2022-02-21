package com.loopy.AcquaintanceInformationManagementSystem.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
public class Person {

    @GeneratedValue
    @Id
    private Long id;

    @NonNull
    private String name;

    private String hobby;

    @NonNull
    private int age;

    private String bloodType;

    private String address;

    private String job;

    @ToString.Exclude
    private String phoneNumber;
}

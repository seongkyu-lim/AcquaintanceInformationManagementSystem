package com.loopy.AcquaintanceInformationManagementSystem.domain;

import com.loopy.AcquaintanceInformationManagementSystem.domain.dto.Birthday;
import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;


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

    @NonNull
    private String bloodType;

    private String address;

    private String job;

    @Valid
    @Embedded
    private Birthday birthday;

    @ToString.Exclude
    private String phoneNumber;

    //cascade : person에서 block의 영속성까지 함께관리하겠다는 의미.
    //block을 먼저 저장해주고 person과 이어줄 필요없이 block을 생성하여 넣어주고 person을 save해주면 자동으로 block도 save해줌.
    //ALL키워드를 사용하면 save뿐아니라 delete등등도 함꼐 관리해 줌.
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Block block;
}

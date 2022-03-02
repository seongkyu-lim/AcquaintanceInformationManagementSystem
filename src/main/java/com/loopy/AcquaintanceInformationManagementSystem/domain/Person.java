package com.loopy.AcquaintanceInformationManagementSystem.domain;

import com.loopy.AcquaintanceInformationManagementSystem.domain.dto.Birthday;
import com.loopy.AcquaintanceInformationManagementSystem.domain.dto.PersonDto;
import lombok.*;
import org.springframework.util.StringUtils;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;


@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Entity
public class Person {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @NonNull
    @NotEmpty
    @Column(nullable = false)
    private String name;

    @NonNull
    @Min(1)
    private int age;

    @NonNull
    @NotEmpty
    @Column(nullable = false)
    private String bloodType;

    private String hobby;

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


    public void set(PersonDto dto){
        if (dto.getAge()!= 0){
            this.setAge(dto.getAge());
        }
        if(!StringUtils.isEmpty(dto.getHobby())){
            this.setHobby(dto.getHobby());
        }
        if(!StringUtils.isEmpty(dto.getBloodType())){
            this.setBloodType(dto.getBloodType());
        }
        if(!StringUtils.isEmpty(dto.getAddress())){
            this.setAddress(dto.getAddress());
        }
        if(!StringUtils.isEmpty(dto.getJob())){
            this.setJob(dto.getJob());
        }
        if(!StringUtils.isEmpty(dto.getPhoneNumber())){
            this.setPhoneNumber(dto.getPhoneNumber());
        }
    }
}

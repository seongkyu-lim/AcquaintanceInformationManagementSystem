package com.loopy.AcquaintanceInformationManagementSystem.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;

//entity에 속해있는 dto임을 표시.
@Embeddable
@NoArgsConstructor
@Data
public class Birthday {

    private int yearOfBirthday;
    @Min(1)
    @Max(12)
    private int monthOfBirthday;

    @Min(1)
    @Max(31)
    private int dayOfBirthday;

    public Birthday(LocalDate date){

        this.yearOfBirthday = date.getYear();
        this.monthOfBirthday = date.getMonthValue();
        this.dayOfBirthday = date.getDayOfMonth();

    }
}

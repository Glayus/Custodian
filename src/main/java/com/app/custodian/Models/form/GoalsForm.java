package com.app.custodian.Models.form;

import com.app.custodian.Models.Entity.Goals;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
@Data
public class GoalsForm {
    @NotBlank
    private String name;
    @Future
    private LocalDate date;

    private LocalTime beginTime;

    private LocalTime endTime;

    public Goals toEntity(){
        Goals goal = new Goals();
        goal.setName(name);
        goal.setDate(date);
        goal.setBeginTime(beginTime);
        goal.setEndTime(endTime);
        return goal;
    }

}


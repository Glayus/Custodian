package com.app.custodian.Models.form;

import com.app.custodian.Models.Entity.Goals;
import com.app.custodian.validation.Constraints.MinFuture;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
@Data
public class GoalsForm {
    @NotBlank
    private String name;
    private boolean accomplished;
    @MinFuture(amount = 0, unit = ChronoUnit.DAYS)
    private LocalDate date;

    private LocalTime beginTime;

    private LocalTime endTime;

    public Goals toEntity(){
        Goals goal = new Goals();
        goal.setName(name);
        goal.setAccomplished(accomplished);
        goal.setDate(date);
        goal.setBeginTime(beginTime);
        goal.setEndTime(endTime);
        return goal;
    }

}


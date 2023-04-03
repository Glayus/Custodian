package com.app.custodian.Models.DTO;

import com.app.custodian.Models.Entity.Goals;
import com.app.custodian.Models.Entity.User;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
public class GoalsDTO {
    private Long id;
    private String name;
    private boolean accomplished;
    private LocalDate date;
    private LocalTime beginTime;
    private LocalTime endTime;
    private User user;

    public static GoalsDTO from(Goals entity){
        if( entity == null )
            return null;

        return GoalsDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .accomplished(entity.isAccomplished())
                .date(entity.getDate())
                .beginTime(entity.getBeginTime())
                .endTime(entity.getEndTime())
                .build();
    }

}


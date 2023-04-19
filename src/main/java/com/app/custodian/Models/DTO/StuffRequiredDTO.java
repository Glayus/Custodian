package com.app.custodian.Models.DTO;

import com.app.custodian.Models.Entity.StuffRequired;
import com.app.custodian.Models.Entity.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StuffRequiredDTO {

    private Long id;
    private String name;
    private User user;

    public static StuffRequiredDTO from(StuffRequired entity){
        if( entity == null )
            return null;

        return StuffRequiredDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }
}

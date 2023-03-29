package Models.DTO;

import Models.Entity.Goals;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GoalsDTO {  private Long id;
    private String name;

    public static GoalsDTO from(Goals entity){
        if( entity == null )
            return null;

        return GoalsDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

}


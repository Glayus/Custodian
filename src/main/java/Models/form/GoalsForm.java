package Models.form;

import Models.Entity.Goals;
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
        Goals.setName(name);
        Goals.setAccomplished(accomplished);
        Goals.setDate(date);
        Goals.setBeginTime(beginTime);
        Goals.setEndTime(endTime);
        return goal;
    }

}


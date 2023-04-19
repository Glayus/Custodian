package com.app.custodian.Models.form;

import com.app.custodian.Models.Entity.StuffRequired;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class StuffRequiredForm {
    @NotBlank
    private String name;

    public StuffRequired toEntity() {
        StuffRequired stuffRequired = new StuffRequired();
        stuffRequired.setName(name);
        return stuffRequired;
    }
}

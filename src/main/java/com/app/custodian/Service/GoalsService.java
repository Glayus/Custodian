package com.app.custodian.Service;

import com.app.custodian.Models.DTO.GoalsDTO;
import com.app.custodian.Models.form.GoalsForm;

import java.util.List;

public interface GoalsService {

    List<GoalsDTO> getAll();
    GoalsDTO getCurrent(String login);

    void create (GoalsForm goalsForm);
}

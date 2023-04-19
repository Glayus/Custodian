package com.app.custodian.Service;

import com.app.custodian.Models.DTO.StuffRequiredDTO;
import com.app.custodian.Models.form.StuffRequiredForm;

import java.util.List;
public interface StuffRequiredService  {

    List<StuffRequiredDTO>getAll(String login);

    void create(StuffRequiredForm stuffRequiredForm, String login);

    void delete(long id);
}

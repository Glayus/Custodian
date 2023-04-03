package com.app.custodian.Service.impl;

import com.app.custodian.Models.DTO.GoalsDTO;
import com.app.custodian.Models.Entity.Goals;
import com.app.custodian.Models.form.GoalsForm;
import com.app.custodian.Repository.GoalsRepository;
import com.app.custodian.Service.GoalsService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class GoalsServiceImpl implements GoalsService {

private final GoalsRepository goalsRepository;

public GoalsServiceImpl (GoalsRepository goalsRepository) {this.goalsRepository=goalsRepository;}


    @Override
    public List<GoalsDTO> getAll() {
        return goalsRepository.findAll()
                .stream()
                .map(GoalsDTO::from)
                .toList();
    }

    @Override
    public GoalsDTO getCurrent(String username) {
        return goalsRepository.findByUser_LoginAndDate(username,LocalDate.now())
                .map( GoalsDTO::from )
                .orElse(null);
    }

    @Override
    public void create(GoalsForm form) {
        Goals goal = new Goals();

        goal.setName(form.getName());
        goal.setDate(form.getDate());
        goal.setBeginTime(form.getBeginTime());
        goal.setEndTime(form.getEndTime());

        goalsRepository.save(goal);
    }


}

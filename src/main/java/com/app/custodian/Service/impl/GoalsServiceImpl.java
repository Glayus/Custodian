package com.app.custodian.Service.impl;

import com.app.custodian.Models.DTO.GoalsDTO;
import com.app.custodian.Models.Entity.Goals;
import com.app.custodian.Models.Entity.User;
import com.app.custodian.Models.form.GoalsForm;
import com.app.custodian.Repository.GoalsRepository;
import com.app.custodian.Repository.UserRepository;
import com.app.custodian.Service.GoalsService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class GoalsServiceImpl implements GoalsService {

    private final GoalsRepository goalsRepository;
    private final UserRepository userRepository;

    public GoalsServiceImpl (GoalsRepository goalsRepository, UserRepository userRepository) {
        this.goalsRepository=goalsRepository;
        this.userRepository = userRepository;
    }


    @Override
    public List<GoalsDTO> getAll(String login) {
        User user = userRepository.findByLogin(login).orElseThrow();
        return goalsRepository.findByUser(user)
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
    public void create(GoalsForm form, String login) {

        User user = userRepository.findByLogin(login)
                .orElseThrow();


        if (form.getBeginTime().isAfter(form.getEndTime())) {
            throw new RuntimeException("End time can't be before begin time");
        }
        Goals goal = form.toEntity();
        goal.setAccomplished(false);

        goal.setUser(user);

        goalsRepository.save(goal);
    }


}

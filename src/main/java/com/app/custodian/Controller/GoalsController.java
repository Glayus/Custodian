package com.app.custodian.Controller;

import Models.DTO.GoalsDTO;
import com.app.custodian.Service.GoalsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/goals")
public class GoalsController {

    private final GoalsService goalsService;

    public GoalsController (GoalsService goalsService) {this.goalsService = goalsService;}

    @GetMapping
    public List<GoalsDTO> getAll(){
        return goalsService.getAll();
    }
}

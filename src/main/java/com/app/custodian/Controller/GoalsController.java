package com.app.custodian.Controller;

import com.app.custodian.Models.DTO.GoalsDTO;
import com.app.custodian.Models.form.GoalsForm;
import com.app.custodian.Service.GoalsService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/goals")
public class GoalsController {

    private final GoalsService goalsService;

    public GoalsController (GoalsService goalsService) {this.goalsService = goalsService;}


    @PostMapping("/create")
    public void processCreateForm(Authentication auth, @RequestBody GoalsForm form){
        goalsService.create( form, auth.getName() );
    }

    @GetMapping
    public List<GoalsDTO> getAll(Authentication auth){
        return goalsService.getAll(auth.getName());
    }
    @GetMapping("/current")
    public GoalsDTO displayCurrent(Authentication auth){
        return goalsService.getCurrent( auth.getName() );
    }
}

package com.app.custodian.Controller;

import com.app.custodian.Models.DTO.GoalsDTO;
import com.app.custodian.Models.form.GoalsForm;
import com.app.custodian.Service.GoalsService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/goals")
public class GoalsController {

    private final GoalsService goalsService;

    public GoalsController (GoalsService goalsService) {this.goalsService = goalsService;}


    @PostMapping("/goal/create")
    public void processCreateForm(GoalsForm form){
        goalsService.create( form );
    }

    @GetMapping
    public List<GoalsDTO> getAll(){
        return goalsService.getAll();
    }
    @GetMapping("/goal/{date:current}")
    public GoalsDTO displayCurrent(Authentication auth){
        return goalsService.getCurrent( auth.name() );
    }
}

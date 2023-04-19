package com.app.custodian.Controller;

import com.app.custodian.Models.DTO.StuffRequiredDTO;
import com.app.custodian.Models.form.StuffRequiredForm;
import com.app.custodian.Service.StuffRequiredService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/checklist")
public class StuffRequiredController {

    private final StuffRequiredService stuffRequiredService;

    public StuffRequiredController (StuffRequiredService stuffRequiredService) {this.stuffRequiredService = stuffRequiredService;}

    @PostMapping("/create")
    public void processCreateForm(Authentication auth, @RequestBody StuffRequiredForm form){
        stuffRequiredService.create( form, auth.getName() );
    }

    @GetMapping
    public List<StuffRequiredDTO> getAll(Authentication auth){
        return stuffRequiredService.getAll(auth.getName());
    }

    @DeleteMapping("/{id}")
    public void processDeleteObject(@PathVariable long id) {
        stuffRequiredService.delete(id);
    }
}




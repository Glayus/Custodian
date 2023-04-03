package com.app.custodian.Controller;

import com.app.custodian.Models.DTO.AuthDTO;
import com.app.custodian.Models.form.LoginForm;
import com.app.custodian.Models.form.UserForm;
import com.app.custodian.Service.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public AuthDTO login(@RequestBody @Valid LoginForm form){
        return authService.login(form);
    }

    @PostMapping("/register")
    public AuthDTO register(@RequestBody @Valid UserForm form){
        return authService.register(form);
    }

}

package com.app.custodian.Service;

import com.app.custodian.Models.DTO.AuthDTO;
import com.app.custodian.Models.form.LoginForm;
import com.app.custodian.Models.form.UserForm;

public interface AuthService {
    AuthDTO login(LoginForm form);
    AuthDTO register(UserForm form);

}


package com.app.custodian.Models.form;

import com.app.custodian.Models.Entity.Role;
import com.app.custodian.Models.Entity.Sex;
import com.app.custodian.Models.Entity.User;
import com.app.custodian.validation.Constraints.ValidPassword;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class UserForm {
    @NotBlank
    @Size(min = 6)
    private String login;
    @Email
    private String eMail;
    @ValidPassword
    private String password;
    @NotNull
    private Role role;
    private Sex sex;
    private String activity;

    public User toEntity(){
        User user = new User();
        user.setLogin(login);
        user.setEMail(eMail);
        user.setPassword(password);
        user.setRole(role);
        user.setSex(sex);
        user.setActivity(activity);
        return user;
    }

}

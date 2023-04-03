package com.app.custodian.Models.DTO;

import com.app.custodian.Models.Entity.Goals;
import com.app.custodian.Models.Entity.Role;
import com.app.custodian.Models.Entity.Sex;
import com.app.custodian.Models.Entity.User;
import lombok.Builder;
import lombok.Data;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Builder
public class UserDTO {
    private Long id;
    private String login;
    private String eMail;
    private String password;
    private Role role;
    private Sex sex;
    private String activity;
    private Set<Goals> goals = new LinkedHashSet<>();

    public static UserDTO from(User entity) {
        if (entity == null)
            return null;

        return UserDTO.builder()
                .id(entity.getId())
                .login(entity.getLogin())
                .eMail(entity.getEMail())
                .password(entity.getPassword())
                .role(entity.getRole())
                .sex(entity.getSex())
                .build();
    }
}

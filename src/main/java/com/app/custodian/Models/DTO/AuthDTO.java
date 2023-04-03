package com.app.custodian.Models.DTO;

import com.app.custodian.Models.Entity.Role;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthDTO {
    private String token;
    private String username;
    private Role role;
}

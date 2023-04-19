package com.app.custodian.Models.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "\"user\"")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long id;
    @Column(name = "login", nullable = false, unique = true)
    private String login;

    @Column(name = "email", nullable = false, unique = true)
    private String eMail;
    @Column(nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;
    @Enumerated(EnumType.STRING)
    @Column(name = "sex")
    private Sex sex;

    @Column (name = "activity")
    private String activity;

    @OneToMany(mappedBy = "user")
    private Set<Goals> goals = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user")
    private Set<StuffRequired> stuffRequired = new LinkedHashSet<>();
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_"+role));
    }

    @Override
    public String getUsername() {
        return getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

package com.app.custodian.Service.impl;

import com.app.custodian.Models.DTO.AuthDTO;
import com.app.custodian.Models.Entity.Role;
import com.app.custodian.Models.Entity.User;
import com.app.custodian.Models.form.LoginForm;
import com.app.custodian.Models.form.UserForm;
import com.app.custodian.Repository.UserRepository;
import com.app.custodian.Service.AuthService;
import com.app.custodian.Utils.JWTProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authManager;
    private final JWTProvider jwtProvider;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthServiceImpl (
            AuthenticationManager authManager,
            JWTProvider jwtProvider,
            UserRepository userRepository,
            PasswordEncoder passwordEncoder
    ) {
        this.authManager = authManager;
        this.jwtProvider = jwtProvider;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AuthDTO login(LoginForm form) {

        authManager.authenticate( new UsernamePasswordAuthenticationToken(form.getLogin(),form.getPassword()) );

        User user = userRepository.findByLogin(form.getLogin() )
                .orElseThrow();

        String token = jwtProvider.generateToken(((User) user).getUsername(), user.getRole() );

        return AuthDTO.builder()
                .token(token)
                .username(user.getUsername())
                .role(user.getRole())
                .build();
    }

    @Override
    public AuthDTO register(UserForm form) {
        User user;
        user = form.toEntity();
        user.setRole(Role.PROCRASTINATOR);
        user.setPassword( passwordEncoder.encode(form.getPassword()) );
        user = userRepository.save( user );

        String token = jwtProvider.generateToken(user.getUsername(), user.getRole());

        return AuthDTO.builder()
                .token(token)
                .username(user.getUsername())
                .role(user.getRole())
                .build();
    }
}

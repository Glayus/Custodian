package com.app.custodian.Service.impl;

import com.app.custodian.Models.DTO.StuffRequiredDTO;
import com.app.custodian.Models.Entity.StuffRequired;
import com.app.custodian.Models.Entity.User;
import com.app.custodian.Models.form.StuffRequiredForm;
import com.app.custodian.Repository.StuffRequiredRepository;
import com.app.custodian.Repository.UserRepository;
import com.app.custodian.Service.StuffRequiredService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StuffRequiredServiceImpl implements StuffRequiredService {

    private final UserRepository userRepository;

    private final StuffRequiredRepository stuffRequiredRepository;

    public StuffRequiredServiceImpl(UserRepository userRepository, StuffRequiredRepository stuffRequiredRepository) {
        this.userRepository = userRepository;
        this.stuffRequiredRepository = stuffRequiredRepository;
    }

    public List<StuffRequiredDTO> getAll(String login) {
        User user = userRepository.findByLogin(login).orElseThrow();
        return stuffRequiredRepository.findByUser(user)
                .stream()
                .map(StuffRequiredDTO::from)
                .toList();
    }

    @Override
    public void create(StuffRequiredForm form, String login) {

        User user = userRepository.findByLogin(login)
                .orElseThrow();

        StuffRequired stuffRequired = form.toEntity();

        stuffRequired.setUser(user);

        stuffRequiredRepository.save(stuffRequired);
    }

    @Override
    public void delete(long id) {
        if( !stuffRequiredRepository.existsById(id) )
            throw new RuntimeException("Object not found");

        stuffRequiredRepository.deleteById(id);
    }

}

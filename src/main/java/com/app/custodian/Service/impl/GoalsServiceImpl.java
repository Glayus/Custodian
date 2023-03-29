package com.app.custodian.Service.impl;
import java.util.List;
import Models.DTO.GoalsDTO;
import com.app.custodian.Repository.GoalsRepository;
import com.app.custodian.Service.GoalsService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GoalsServiceImpl implements GoalsService {

private final GoalsRepository goalsRepository;

public GoalsServiceImpl (GoalsRepository goalsRepository) {this.goalsRepository=goalsRepository;}


    @Override
    public List<GoalsDTO> getAll() {
        return GoalsRepository.findAll()
                .stream()
                .map(GoalsDTO::from)
                .toList();
    }
}

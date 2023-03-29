package com.app.custodian.Service;

import Models.DTO.GoalsDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface GoalsService {

    List<GoalsDTO> getAll();
}

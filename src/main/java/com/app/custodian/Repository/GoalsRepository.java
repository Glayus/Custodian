package com.app.custodian.Repository;
import com.app.custodian.Models.Entity.Goals;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface GoalsRepository extends JpaRepository<Goals, Long> {
    Optional<Goals> findByUser_LoginAndDate(String login, LocalDate date);

}

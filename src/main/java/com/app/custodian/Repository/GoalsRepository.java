package com.app.custodian.Repository;
import Models.Entity.Goals;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalsRepository extends JpaRepository<Goals, Long> {
}

package com.app.custodian.Repository;

import com.app.custodian.Models.Entity.StuffRequired;
import com.app.custodian.Models.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface StuffRequiredRepository extends JpaRepository<StuffRequired, Long> {

    List<StuffRequired> findByUser (User user);
}

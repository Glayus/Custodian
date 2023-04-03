package com.app.custodian.Models.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter @Setter
public class Goals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "goal_id", nullable = false)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;

    @Column (name= "accomplished")
    private boolean accomplished;
    @Column(nullable = false)
    private LocalDate date;
    @Column(nullable = false)
    private LocalTime beginTime;
    @Column(nullable = false)
    private LocalTime endTime;
    @ManyToOne
    @JoinColumn(nullable = false)
    private User user;



}

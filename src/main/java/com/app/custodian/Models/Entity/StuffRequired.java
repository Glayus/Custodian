package com.app.custodian.Models.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter @Setter
public class StuffRequired {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stuff_id", nullable = false)
    private Long id;
    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(nullable = false)
    private User user;
}

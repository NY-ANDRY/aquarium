package com.aquarium.models.tables;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_periods")
public class Period {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = true)
    private String name;

    @Column(name = "begin_at", nullable = true)
    private LocalDateTime begin;

    @Column(name = "end_at", nullable = true)
    private LocalDateTime end;

    @OneToMany(mappedBy = "period")
    private List<Aquarium> aquariums;
}

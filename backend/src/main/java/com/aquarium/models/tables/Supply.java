package com.aquarium.models.tables;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_supplies")
public class Supply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "begin_at", nullable = true)
    private LocalDateTime begin;

    @Column(name = "end_at", nullable = true)
    private LocalDateTime end;

    @ManyToOne
    @JoinColumn(name = "id_aquarium")
    private Aquarium aquarium;

    @OneToMany(mappedBy = "supply")
    private List<Feed> feeds;
}

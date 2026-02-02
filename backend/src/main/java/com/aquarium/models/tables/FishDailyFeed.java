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
@Table(name = "t_fish_daily_feed")
public class FishDailyFeed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "increase")
    private double increase;

    @Column(name = "begin_weight")
    private double beginWeight;

    @Column(name = "end_weight")
    private double endWeight;

    @ManyToOne
    @JoinColumn(name = "id_fish")
    private Fish fish;

    @Column(name = "date", nullable = true)
    private LocalDateTime date;

    @OneToMany(mappedBy = "fishDailyFeed")
    private List<FishDailyNutrient> fishDailyNutrient;
}

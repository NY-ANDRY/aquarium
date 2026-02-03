package com.aquarium.models.tables;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_fish_daily_nutrients")
public class FishDailyNutrient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "qtt", nullable = true)
    private double qtt;

    @Column(name = "increase_weight", nullable = true)
    private double increaseWeight;

    @ManyToOne
    @JoinColumn(name = "id_nutrient")
    private Nutrient nutrient;

    @ManyToOne
    @JoinColumn(name = "id_fish_daily_feed")
    private FishDailyFeed fishDailyFeed;

}

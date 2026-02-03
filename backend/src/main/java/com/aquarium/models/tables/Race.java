package com.aquarium.models.tables;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_races")
public class Race {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = true)
    private String name;

    @Column(name = "purchase_price")
    private double purchasePrice;

    @Column(name = "sale_price")
    private double salePrice;

    @Column(name = "max_weight")
    private double maxWeight;

    @Column(name = "increase_capacity")
    private double increaseCapacity;

    @OneToMany(mappedBy = "race")
    private List<RaceNutrient> raceNutrients;

    @OneToMany(mappedBy = "race")
    private List<Fish> fish;
}

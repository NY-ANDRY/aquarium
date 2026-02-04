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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }

    public double getIncreaseCapacity() {
        return increaseCapacity;
    }

    public void setIncreaseCapacity(double increaseCapacity) {
        this.increaseCapacity = increaseCapacity;
    }

    public List<RaceNutrient> getRaceNutrients() {
        return raceNutrients;
    }

    public void setRaceNutrients(List<RaceNutrient> raceNutrients) {
        this.raceNutrients = raceNutrients;
    }

    public List<Fish> getFish() {
        return fish;
    }

    public void setFish(List<Fish> fish) {
        this.fish = fish;
    }

}

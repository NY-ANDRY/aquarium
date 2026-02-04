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

    @ManyToOne
    @JoinColumn(name = "id_nutrient")
    private Nutrient nutrient;

    @Column(name = "qtt", nullable = true)
    private double qtt;

    @ManyToOne
    @JoinColumn(name = "id_fish_daily_Aliment")
    private FishDailyAliment fishDailyAliment;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Nutrient getNutrient() {
        return nutrient;
    }

    public void setNutrient(Nutrient nutrient) {
        this.nutrient = nutrient;
    }

    public double getQtt() {
        return qtt;
    }

    public void setQtt(double qtt) {
        this.qtt = qtt;
    }

    public FishDailyAliment getFishDailyAliment() {
        return fishDailyAliment;
    }

    public void setFishDailyAliment(FishDailyAliment fishDailyAliment) {
        this.fishDailyAliment = fishDailyAliment;
    }

}

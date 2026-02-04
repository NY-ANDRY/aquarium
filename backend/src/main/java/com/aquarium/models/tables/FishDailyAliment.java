package com.aquarium.models.tables;

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
@Table(name = "t_fish_daily_aliments")
public class FishDailyAliment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_aliment")
    private Aliment aliment;

    @Column(name = "qtt")
    private double qtt;

    @ManyToOne
    @JoinColumn(name = "id_fish_daily_feed")
    private FishDailyFeed fishDailyFeed;

    @OneToMany(mappedBy = "fishDailyAliment")
    private List<FishDailyNutrient> fishDailyNutrient;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getQtt() {
        return qtt;
    }

    public void setQtt(double qtt) {
        this.qtt = qtt;
    }

    public Aliment getAliment() {
        return aliment;
    }

    public void setAliment(Aliment aliment) {
        this.aliment = aliment;
    }

    public FishDailyFeed getFishDailyFeed() {
        return fishDailyFeed;
    }

    public void setFishDailyFeed(FishDailyFeed fishDailyFeed) {
        this.fishDailyFeed = fishDailyFeed;
    }

    public List<FishDailyNutrient> getFishDailyNutrient() {
        return fishDailyNutrient;
    }

    public void setFishDailyNutrient(List<FishDailyNutrient> fishDailyNutrient) {
        this.fishDailyNutrient = fishDailyNutrient;
    }

}

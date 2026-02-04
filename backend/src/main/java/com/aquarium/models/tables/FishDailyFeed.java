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
@Table(name = "t_fish_daily_feeds")
public class FishDailyFeed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "increase_weight")
    private double increaseWeight;

    @ManyToOne
    @JoinColumn(name = "id_fish")
    private Fish fish;

    @Column(name = "date", nullable = true)
    private LocalDateTime date;

    @OneToMany(mappedBy = "fishDailyFeed")
    private List<FishDailyAliment> fishDailyAliments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getIncreaseWeight() {
        return increaseWeight;
    }

    public void setIncreaseWeight(double increaseWeight) {
        this.increaseWeight = increaseWeight;
    }

    public Fish getFish() {
        return fish;
    }

    public void setFish(Fish fish) {
        this.fish = fish;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public List<FishDailyAliment> getFishDailyAliments() {
        return fishDailyAliments;
    }

    public void setFishDailyAliments(List<FishDailyAliment> fishDailyAliments) {
        this.fishDailyAliments = fishDailyAliments;
    }

}

package com.aquarium.models.tables;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_fish_daily_logs")
public class FishDailyLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "increase_weight")
    private double increaseWeight;

    @Column(name = "begin_weight")
    private double beginWeight;

    @Column(name = "end_weight")
    private double endWeight;

    @ManyToOne
    @JoinColumn(name = "id_fish")
    private Fish fish;

    @Column(name = "date", nullable = true)
    private LocalDateTime date;

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

    public double getBeginWeight() {
        return beginWeight;
    }

    public void setBeginWeight(double beginWeight) {
        this.beginWeight = beginWeight;
    }

    public double getEndWeight() {
        return endWeight;
    }

    public void setEndWeight(double endWeight) {
        this.endWeight = endWeight;
    }

}

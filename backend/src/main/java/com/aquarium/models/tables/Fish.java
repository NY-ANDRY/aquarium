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
import jakarta.persistence.Transient;

@Entity
@Table(name = "t_fish")
public class Fish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = true)
    private String name;

    @Column(name = "initial_weight")
    private double initialWeight;

    @ManyToOne
    @JoinColumn(name = "id_species")
    private Species species;

    @ManyToOne
    @JoinColumn(name = "id_aquarium", nullable = true)
    private Aquarium aquarium;

    @OneToMany(mappedBy = "fish")
    private List<FishDailyFeed> fishDailyFeeds;

    @OneToMany(mappedBy = "fish")
    private List<FishDailyLog> fishDailylogs;

    @Transient
    private LocalDateTime curDatetime;

    @Transient
    private double curWeight;

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

    public double getInitialWeight() {
        return initialWeight;
    }

    public void setInitialWeight(double initialWeight) {
        this.initialWeight = initialWeight;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public Aquarium getAquarium() {
        return aquarium;
    }

    public void setAquarium(Aquarium aquarium) {
        this.aquarium = aquarium;
    }

    public List<FishDailyFeed> getFishDailyFeeds() {
        return fishDailyFeeds;
    }

    public void setFishDailyFeeds(List<FishDailyFeed> fishDailyFeeds) {
        this.fishDailyFeeds = fishDailyFeeds;
    }

    public List<FishDailyLog> getFishDailylogs() {
        return fishDailylogs;
    }

    public void setFishDailylogs(List<FishDailyLog> fishDailylogs) {
        this.fishDailylogs = fishDailylogs;
    }

    public LocalDateTime getCurDatetime() {
        return curDatetime;
    }

    public void setCurDatetime(LocalDateTime datetime) {
        this.curDatetime = datetime;
    }

    public double getCurWeight() {
        return curWeight;
    }

    public void setCurWeight(double curWeight) {
        this.curWeight = curWeight;
    }

}

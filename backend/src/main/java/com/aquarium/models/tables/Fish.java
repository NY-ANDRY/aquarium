package com.aquarium.models.tables;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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

    @Column(name = "initial_weight", precision = 20, scale = 10)
    private BigDecimal initialWeight;

    @ManyToOne
    @JoinColumn(name = "id_species")
    @JsonManagedReference
    private Species species;

    @ManyToOne
    @JoinColumn(name = "id_aquarium", nullable = true)
    @JsonManagedReference
    private Aquarium aquarium;

    @OneToMany(mappedBy = "fish")
    @JsonIgnore
    private List<FishDailyFeed> fishDailyFeeds;

    @Transient
    private LocalDateTime curDatetime;

    @Transient
    private BigDecimal curWeight;

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

    public BigDecimal getInitialWeight() {
        return initialWeight;
    }

    public void setInitialWeight(BigDecimal initialWeight) {
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

    public LocalDateTime getCurDatetime() {
        return curDatetime;
    }

    public void setCurDatetime(LocalDateTime datetime) {
        this.curDatetime = datetime;
    }

    public BigDecimal getCurWeight() {
        return curWeight;
    }

    public void setCurWeight(BigDecimal curWeight) {
        this.curWeight = curWeight;
    }

}

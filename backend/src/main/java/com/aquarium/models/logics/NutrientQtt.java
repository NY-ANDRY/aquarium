package com.aquarium.models.logics;

import java.math.BigDecimal;

import com.aquarium.models.tables.Fish;
import com.aquarium.models.tables.Nutrient;

public class NutrientQtt {
    private Fish fish;
    private Nutrient nutrient;
    private BigDecimal qtt;
    private BigDecimal cur;
    private BigDecimal rest;

    private BigDecimal raceNeed;
    private BigDecimal subNb;
    private BigDecimal subWeight;
    private BigDecimal weightInc;

    public Nutrient getNutrient() {
        return nutrient;
    }

    public void setNutrient(Nutrient nutrient) {
        this.nutrient = nutrient;
    }

    public BigDecimal getQtt() {
        return qtt;
    }

    public void setQtt(BigDecimal qtt) {
        this.qtt = qtt;
    }

    public BigDecimal getRest() {
        return rest;
    }

    public void setRest(BigDecimal rest) {
        this.rest = rest;
    }

    public BigDecimal getCur() {
        return cur;
    }

    public void setCur(BigDecimal cur) {
        this.cur = cur;
    }

    public Fish getFish() {
        return fish;
    }

    public void setFish(Fish fish) {
        this.fish = fish;
    }

    public BigDecimal getSubNb() {
        return subNb;
    }

    public void setSubNb(BigDecimal subNb) {
        this.subNb = subNb;
    }

    public BigDecimal getSubWeight() {
        return subWeight;
    }

    public void setSubWeight(BigDecimal unitInc) {
        this.subWeight = unitInc;
    }

    public BigDecimal getWeightInc() {
        return weightInc;
    }

    public void setWeightInc(BigDecimal weightInc) {
        this.weightInc = weightInc;
    }

    public BigDecimal getRaceNeed() {
        return raceNeed;
    }

    public void setRaceNeed(BigDecimal raceNeed) {
        this.raceNeed = raceNeed;
    }

}

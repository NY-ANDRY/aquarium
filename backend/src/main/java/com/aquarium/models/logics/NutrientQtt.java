package com.aquarium.models.logics;

import com.aquarium.models.tables.Fish;
import com.aquarium.models.tables.Nutrient;

public class NutrientQtt {
    private Fish fish;
    private Nutrient nutrient;
    private double qtt;
    private double cur;
    private double rest;

    private double raceNeed;
    private int subNb;
    private double subWeight;
    private double weightInc;

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

    public double getRest() {
        return rest;
    }

    public void setRest(double rest) {
        this.rest = rest;
    }

    public double getCur() {
        return cur;
    }

    public void setCur(double cur) {
        this.cur = cur;
    }

    public Fish getFish() {
        return fish;
    }

    public void setFish(Fish fish) {
        this.fish = fish;
    }

    public int getSubNb() {
        return subNb;
    }

    public void setSubNb(int subNb) {
        this.subNb = subNb;
    }

    public double getSubWeight() {
        return subWeight;
    }

    public void setSubWeight(double unitInc) {
        this.subWeight = unitInc;
    }

    public double getWeightInc() {
        return weightInc;
    }

    public void setWeightInc(double weightInc) {
        this.weightInc = weightInc;
    }

    public double getRaceNeed() {
        return raceNeed;
    }

    public void setRaceNeed(double raceNeed) {
        this.raceNeed = raceNeed;
    }

}

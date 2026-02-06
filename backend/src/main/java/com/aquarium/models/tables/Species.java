package com.aquarium.models.tables;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_species")
public class Species {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = true)
    private String name;

    @Column(name = "purchase_price", precision = 20, scale = 10)
    private BigDecimal purchasePrice;

    @Column(name = "sale_price", precision = 20, scale = 10)
    private BigDecimal salePrice;

    @Column(name = "max_weight", precision = 20, scale = 10)
    private BigDecimal maxWeight;

    @Column(name = "increase_capacity", precision = 20, scale = 10)
    private BigDecimal increaseCapacity;

    @OneToMany(mappedBy = "species")
    @JsonManagedReference
    private List<SpeciesNutrient> speciesNutrients;

    @OneToMany(mappedBy = "species")
    @JsonBackReference
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

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public BigDecimal getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(BigDecimal maxWeight) {
        this.maxWeight = maxWeight;
    }

    public BigDecimal getIncreaseCapacity() {
        return increaseCapacity;
    }

    public void setIncreaseCapacity(BigDecimal increaseCapacity) {
        this.increaseCapacity = increaseCapacity;
    }

    public List<SpeciesNutrient> getSpeciesNutrients() {
        return speciesNutrients;
    }

    public void setSpeciesNutrients(List<SpeciesNutrient> speciesNutrients) {
        this.speciesNutrients = speciesNutrients;
    }

    public List<Fish> getFish() {
        return fish;
    }

    public void setFish(List<Fish> fish) {
        this.fish = fish;
    }

}

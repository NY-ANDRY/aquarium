package com.aquarium.models.tables;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_species_nutrients")
public class SpeciesNutrient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "need", precision = 20, scale = 10)
    private BigDecimal need;

    @ManyToOne
    @JoinColumn(name = "id_species")
    @JsonBackReference
    private Species species;

    @ManyToOne
    @JoinColumn(name = "id_nutrient")
    private Nutrient nutrient;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getNeed() {
        return need;
    }

    public void setNeed(BigDecimal need) {
        this.need = need;
    }

    public Nutrient getNutrient() {
        return nutrient;
    }

    public void setNutrient(Nutrient nutrient) {
        this.nutrient = nutrient;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

}

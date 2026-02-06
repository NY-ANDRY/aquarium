package com.aquarium.models.tables;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "t_aliments_nutrients")
public class AlimentNutrient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "intake", precision = 20, scale = 10)
    private BigDecimal intake;

    @ManyToOne
    @JoinColumn(name = "id_aliment")
    @JsonBackReference
    private Aliment aliment;

    @ManyToOne
    @JoinColumn(name = "id_nutrient")
    private Nutrient nutrient;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getIntake() {
        return intake;
    }

    public void setIntake(BigDecimal intake) {
        this.intake = intake;
    }

    public Aliment getAliment() {
        return aliment;
    }

    public void setAliment(Aliment aliment) {
        this.aliment = aliment;
    }

    public Nutrient getNutrient() {
        return nutrient;
    }

    public void setNutrient(Nutrient nutrient) {
        this.nutrient = nutrient;
    }
}

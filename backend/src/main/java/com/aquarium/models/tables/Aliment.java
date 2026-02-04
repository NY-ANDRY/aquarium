package com.aquarium.models.tables;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_aliments")
public class Aliment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = true)
    private String name;

    @Column(name = "cost")
    private double cost;

    @OneToMany(mappedBy = "aliment")
    private List<AlimentNutrient> alimentNutrients;

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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public List<AlimentNutrient> getAlimentNutrients() {
        return alimentNutrients;
    }

    public void setAlimentNutrients(List<AlimentNutrient> alimentNutrients) {
        this.alimentNutrients = alimentNutrients;
    }

}

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
@Table(name = "t_nutrients")
public class Nutrient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = true)
    private String name;

    @Column(name = "img", nullable = true)
    private String img;

    @OneToMany(mappedBy = "nutrient")
    private List<AlimentNutrient> alimentNutrients;

    @OneToMany(mappedBy = "nutrient")
    private List<SpeciesNutrient> speciesNutrients;

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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public List<AlimentNutrient> getAlimentNutrients() {
        return alimentNutrients;
    }

    public void setAlimentNutrients(List<AlimentNutrient> alimentNutrients) {
        this.alimentNutrients = alimentNutrients;
    }

    public List<SpeciesNutrient> getSpeciesNutrients() {
        return speciesNutrients;
    }

    public void setSpeciesNutrients(List<SpeciesNutrient> speciesNutrients) {
        this.speciesNutrients = speciesNutrients;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Nutrient other = (Nutrient) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}

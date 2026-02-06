package com.aquarium.services;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

import lombok.RequiredArgsConstructor;
import com.aquarium.repositories.SpeciesRepository;
import com.aquarium.models.tables.Nutrient;
import com.aquarium.models.tables.Species;
import com.aquarium.models.tables.SpeciesNutrient;

@Service
@RequiredArgsConstructor
public class SpeciesService {
    private final SpeciesRepository repository;

    public List<Species> findAll() {
        return repository.findAll();
    }

    public Species findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Nutrient> usedNutrients(Species species) {
        return species.getSpeciesNutrients().stream().map(el -> el.getNutrient()).toList();
    }

    public BigDecimal need(Species species, Nutrient Nutrient) {
        for (SpeciesNutrient rn : species.getSpeciesNutrients()) {
            if (rn.getNutrient().equals(Nutrient)) {
                return rn.getNeed();
            }
        }
        return BigDecimal.ZERO;
    }
}

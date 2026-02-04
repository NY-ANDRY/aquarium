package com.aquarium.services;

import org.springframework.stereotype.Service;

import java.util.List;

import lombok.RequiredArgsConstructor;
import com.aquarium.repositories.RaceRepository;
import com.aquarium.models.tables.Nutrient;
import com.aquarium.models.tables.Race;
import com.aquarium.models.tables.RaceNutrient;

@Service
@RequiredArgsConstructor
public class RaceService {
    private final RaceRepository repository;

    public List<Race> findAll() {
        return repository.findAll();
    }

    public Race findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Nutrient> usedNutrients(Race race) {
        return race.getRaceNutrients().stream().map(el -> el.getNutrient()).toList();
    }

    public double need(Race race, Nutrient Nutrient) {
        for (RaceNutrient rn : race.getRaceNutrients()) {
            if (rn.getNutrient().equals(Nutrient)) {
                return rn.getNeed();
            }
        }
        return 0;
    }
}

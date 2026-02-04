package com.aquarium.services;

import org.springframework.stereotype.Service;

import java.util.List;

import lombok.RequiredArgsConstructor;
import com.aquarium.repositories.FishDailyNutrientRepository;
import com.aquarium.models.tables.FishDailyNutrient;

@Service
@RequiredArgsConstructor
public class FishDailyNutrientService {
    private final FishDailyNutrientRepository repository;

    public List<FishDailyNutrient> findAll() {
        return repository.findAll();
    }

    public FishDailyNutrient findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public FishDailyNutrient save(FishDailyNutrient fda) {
        return repository.save(fda);
    }
}

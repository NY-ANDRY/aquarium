package com.aquarium.services;

import org.springframework.stereotype.Service;

import java.util.List;

import lombok.RequiredArgsConstructor;
import com.aquarium.repositories.FishDailyAlimentRepository;
import com.aquarium.models.tables.FishDailyAliment;
import com.aquarium.models.tables.FishDailyNutrient;

@Service
@RequiredArgsConstructor
public class FishDailyAlimentService {
    private final FishDailyAlimentRepository repository;
    private final FishDailyNutrientService fishDailyNutrientService;

    public List<FishDailyAliment> findAll() {
        return repository.findAll();
    }

    public FishDailyAliment findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public FishDailyAliment save(FishDailyAliment fda) {
        FishDailyAliment result = repository.save(fda);
        for (FishDailyNutrient fdn : fda.getFishDailyNutrient()) {
            fishDailyNutrientService.save(fdn);
        }
        return result;
    }
}

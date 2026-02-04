package com.aquarium.services;

import org.springframework.stereotype.Service;

import java.util.List;

import lombok.RequiredArgsConstructor;
import com.aquarium.repositories.FishDailyAlimentRepository;
import com.aquarium.models.tables.FishDailyAliment;

@Service
@RequiredArgsConstructor
public class FishDailyAlimentService {
    private final FishDailyAlimentRepository repository;

    public List<FishDailyAliment> findAll() {
        return repository.findAll();
    }

    public FishDailyAliment findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public FishDailyAliment save(FishDailyAliment fda) {
        return repository.save(fda);
    }
}

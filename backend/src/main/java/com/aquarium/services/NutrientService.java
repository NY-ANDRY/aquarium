package com.aquarium.services;

import org.springframework.stereotype.Service;

import java.util.List;

import lombok.RequiredArgsConstructor;
import com.aquarium.repositories.NutrientRepository;
import com.aquarium.models.tables.Nutrient;

@Service
@RequiredArgsConstructor
public class NutrientService {
    private final NutrientRepository repository;

    public List<Nutrient> findAll() {
        return repository.findAll();
    }

    public Nutrient findById(Long id) {
        return repository.findById(id).orElse(null);
    }
}

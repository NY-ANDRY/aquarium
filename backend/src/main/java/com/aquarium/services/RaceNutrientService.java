package com.aquarium.services;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.aquarium.repositories.RaceNutrientRepository;

@Service
@RequiredArgsConstructor
public class RaceNutrientService {
    private final RaceNutrientRepository repository;
}

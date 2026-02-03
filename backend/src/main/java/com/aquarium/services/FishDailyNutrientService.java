package com.aquarium.services;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.aquarium.repositories.FishDailyNutrientRepository;

@Service
@RequiredArgsConstructor
public class FishDailyNutrientService {
    private final FishDailyNutrientRepository repository;
}

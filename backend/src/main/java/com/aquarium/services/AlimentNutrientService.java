package com.aquarium.services;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.aquarium.repositories.AlimentNutrientRepository;

@Service
@RequiredArgsConstructor
public class AlimentNutrientService {
    private final AlimentNutrientRepository repository;
}

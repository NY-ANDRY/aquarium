package com.aquarium.services;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.aquarium.repositories.NutrientRepository;

@Service
@RequiredArgsConstructor
public class NutrientService {
    private final NutrientRepository repository;
}

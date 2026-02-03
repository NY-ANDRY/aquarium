package com.aquarium.services;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.aquarium.repositories.AquariumRepository;

@Service
@RequiredArgsConstructor
public class AquariumService {
    private final AquariumRepository repository;
}

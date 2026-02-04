package com.aquarium.services;

import org.springframework.stereotype.Service;

import java.util.List;

import lombok.RequiredArgsConstructor;
import com.aquarium.repositories.AquariumRepository;
import com.aquarium.models.tables.Aquarium;

@Service
@RequiredArgsConstructor
public class AquariumService {
    private final AquariumRepository repository;

    public List<Aquarium> findAll() {
        return repository.findAll();
    }

    public Aquarium findById(Long id) {
        return repository.findById(id).orElse(null);
    }
}

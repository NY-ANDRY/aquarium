package com.aquarium.services;

import org.springframework.stereotype.Service;

import java.util.List;

import lombok.RequiredArgsConstructor;
import com.aquarium.repositories.FlowRepository;
import com.aquarium.models.tables.Flow;

@Service
@RequiredArgsConstructor
public class FlowService {
    private final FlowRepository repository;

    public List<Flow> findAll() {
        return repository.findAll();
    }

    public Flow findById(Long id) {
        return repository.findById(id).orElse(null);
    }
}

package com.aquarium.services;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.aquarium.repositories.RaceRepository;

@Service
@RequiredArgsConstructor
public class RaceService {
    private final RaceRepository repository;
}

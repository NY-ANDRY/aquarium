package com.aquarium.services;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.aquarium.repositories.AlimentRepository;

@Service
@RequiredArgsConstructor
public class AlimentService {
    private final AlimentRepository repository;
}

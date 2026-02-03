package com.aquarium.services;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.aquarium.repositories.FishRepository;

@Service
@RequiredArgsConstructor
public class FishService {
    private final FishRepository repository;
}

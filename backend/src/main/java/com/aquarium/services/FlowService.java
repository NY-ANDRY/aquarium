package com.aquarium.services;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.aquarium.repositories.FlowRepository;

@Service
@RequiredArgsConstructor
public class FlowService {
    private final FlowRepository repository;
}

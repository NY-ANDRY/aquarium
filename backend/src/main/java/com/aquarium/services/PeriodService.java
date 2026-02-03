package com.aquarium.services;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.aquarium.repositories.PeriodRepository;

@Service
@RequiredArgsConstructor
public class PeriodService {
    private final PeriodRepository repository;
}

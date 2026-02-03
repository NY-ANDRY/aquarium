package com.aquarium.services;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.aquarium.repositories.CashFlowRepository;

@Service
@RequiredArgsConstructor
public class CashFlowService {
    private final CashFlowRepository repository;
}

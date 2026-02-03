package com.aquarium.services;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.aquarium.repositories.SupplyRepository;

@Service
@RequiredArgsConstructor
public class SupplyService {
    private final SupplyRepository repository;
}

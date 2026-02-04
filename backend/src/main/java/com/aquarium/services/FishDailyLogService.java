package com.aquarium.services;

import org.springframework.stereotype.Service;

import java.util.List;

import lombok.RequiredArgsConstructor;
import com.aquarium.repositories.FishDailyLogRepository;
import com.aquarium.models.tables.FishDailyLog;

@Service
@RequiredArgsConstructor
public class FishDailyLogService {
    private final FishDailyLogRepository repository;

    public List<FishDailyLog> findAll() {
        return repository.findAll();
    }

    public FishDailyLog findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public FishDailyLog save(FishDailyLog fdl) {
        return repository.save(fdl);
    }
}

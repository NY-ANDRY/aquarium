package com.aquarium.services;

import org.springframework.stereotype.Service;

import java.util.List;

import lombok.RequiredArgsConstructor;
import com.aquarium.repositories.FishDailyFeedRepository;
import com.aquarium.models.tables.Fish;
import com.aquarium.models.tables.FishDailyFeed;

@Service
@RequiredArgsConstructor
public class FishDailyFeedService {
    private final FishDailyFeedRepository repository;

    public List<FishDailyFeed> findAll() {
        return repository.findAll();
    }

    public FishDailyFeed findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public FishDailyFeed save(FishDailyFeed fdf) {
        return repository.save(fdf);
    }

    public List<FishDailyFeed> findAllOf(Fish f) {
        return repository.findByFishId(f.getId());
    }
}

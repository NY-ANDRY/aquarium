package com.aquarium.services;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.aquarium.repositories.FishDailyFeedRepository;

@Service
@RequiredArgsConstructor
public class FishDailyFeedService {
    private final FishDailyFeedRepository repository;
}

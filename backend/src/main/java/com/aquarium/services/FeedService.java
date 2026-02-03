package com.aquarium.services;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.aquarium.repositories.FeedRepository;

@Service
@RequiredArgsConstructor
public class FeedService {
    private final FeedRepository repository;
}

package com.aquarium.services;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

import lombok.RequiredArgsConstructor;
import com.aquarium.repositories.FeedRepository;
import com.aquarium.models.tables.Aliment;
import com.aquarium.models.tables.Feed;

@Service
@RequiredArgsConstructor
public class FeedService {
    private final FeedRepository repository;

    public List<Feed> findAll() {
        return repository.findAll();
    }

    public Feed findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Feed save(Feed feed) {
        return repository.save(feed);
    }

    public BigDecimal expense(Feed feed) {
        BigDecimal result = BigDecimal.ZERO;
        Aliment aliment = feed.getAliment();
        result = result.add(aliment.getCost().multiply(feed.getQtt()));
        return result;
    }
}

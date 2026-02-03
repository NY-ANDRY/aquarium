package com.aquarium.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aquarium.models.tables.FishDailyFeed;

@Repository
public interface FishDailyFeedRepository extends JpaRepository<FishDailyFeed, Long> {
}

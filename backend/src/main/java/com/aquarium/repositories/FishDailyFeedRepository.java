package com.aquarium.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.aquarium.models.tables.FishDailyFeed;

@Repository
public interface FishDailyFeedRepository extends JpaRepository<FishDailyFeed, Long> {
    @Query("SELECT fdf FROM FishDailyFeed fdf WHERE fdf.fish.id = :fishId")
    List<FishDailyFeed> findByFishId(@Param("fishId") Long fishId);
}

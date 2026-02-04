package com.aquarium.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aquarium.models.tables.FishDailyAliment;

@Repository
public interface FishDailyAlimentRepository extends JpaRepository<FishDailyAliment, Long> {
}

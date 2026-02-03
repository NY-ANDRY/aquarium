package com.aquarium.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aquarium.models.tables.RaceNutrient;

@Repository
public interface RaceNutrientRepository extends JpaRepository<RaceNutrient, Long> {
}

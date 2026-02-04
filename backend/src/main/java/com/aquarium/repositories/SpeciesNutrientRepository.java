package com.aquarium.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aquarium.models.tables.SpeciesNutrient;

@Repository
public interface SpeciesNutrientRepository extends JpaRepository<SpeciesNutrient, Long> {
}

package com.aquarium.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aquarium.models.tables.Nutrient;

@Repository
public interface NutrientRepository extends JpaRepository<Nutrient, Long> {
}

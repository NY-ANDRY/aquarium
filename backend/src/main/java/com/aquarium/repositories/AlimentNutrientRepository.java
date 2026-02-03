package com.aquarium.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aquarium.models.tables.AlimentNutrient;

@Repository
public interface AlimentNutrientRepository extends JpaRepository<AlimentNutrient, Long> {
}

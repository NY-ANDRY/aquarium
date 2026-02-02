package com.aquarium.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aquarium.models.tables.MovementType;

public interface MovementTypeRepository extends JpaRepository<MovementType, Long> {
}

package com.aquarium.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aquarium.models.tables.BalanceMovementType;

@Repository
public interface BalanceMovementTypeRepository extends JpaRepository<BalanceMovementType, Long> {
}

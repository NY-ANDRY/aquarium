package com.aquarium.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aquarium.models.tables.Promotion;

public interface PromotionRepository extends JpaRepository<Promotion, Long> {
}

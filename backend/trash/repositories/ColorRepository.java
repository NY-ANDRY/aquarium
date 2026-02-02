package com.aquarium.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aquarium.models.tables.Color;

public interface ColorRepository extends JpaRepository<Color, Long> {
}

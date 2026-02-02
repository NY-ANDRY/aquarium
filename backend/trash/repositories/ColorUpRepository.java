package com.aquarium.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aquarium.models.tables.ColorUp;

@Repository
public interface ColorUpRepository extends JpaRepository<ColorUp, Long> {
}

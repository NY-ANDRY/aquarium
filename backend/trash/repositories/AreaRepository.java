package com.aquarium.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aquarium.models.tables.Area;

@Repository
public interface AreaRepository extends JpaRepository<Area, Long> {
}

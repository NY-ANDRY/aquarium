package com.aquarium.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aquarium.models.tables.Race;

@Repository
public interface RaceRepository extends JpaRepository<Race, Long> {
}

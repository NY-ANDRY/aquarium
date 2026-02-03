package com.aquarium.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aquarium.models.tables.Aquarium;

@Repository
public interface AquariumRepository extends JpaRepository<Aquarium, Long> {
}

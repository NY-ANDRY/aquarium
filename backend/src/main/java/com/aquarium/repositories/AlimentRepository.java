package com.aquarium.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aquarium.models.tables.Aliment;

@Repository
public interface AlimentRepository extends JpaRepository<Aliment, Long> {
}

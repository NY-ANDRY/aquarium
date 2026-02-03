package com.aquarium.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aquarium.models.tables.Fish;

@Repository
public interface FishRepository extends JpaRepository<Fish, Long> {
}

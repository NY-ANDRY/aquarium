package com.aquarium.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aquarium.models.tables.Flow;

@Repository
public interface FlowRepository extends JpaRepository<Flow, Long> {
}

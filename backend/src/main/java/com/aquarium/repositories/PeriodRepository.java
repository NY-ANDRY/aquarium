package com.aquarium.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aquarium.models.tables.Period;

@Repository
public interface PeriodRepository extends JpaRepository<Period, Long> {
}

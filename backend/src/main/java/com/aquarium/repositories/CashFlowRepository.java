package com.aquarium.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aquarium.models.tables.CashFlow;

@Repository
public interface CashFlowRepository extends JpaRepository<CashFlow, Long> {
}

package com.aquarium.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aquarium.models.tables.Supply;

@Repository
public interface SupplyRepository extends JpaRepository<Supply, Long> {
}

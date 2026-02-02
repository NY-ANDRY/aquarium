package com.aquarium.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aquarium.models.tables.Size;

public interface SizeRepository extends JpaRepository<Size, Long> {
}

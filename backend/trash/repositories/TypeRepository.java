package com.aquarium.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aquarium.models.tables.Type;

public interface TypeRepository extends JpaRepository<Type, Long> {
}

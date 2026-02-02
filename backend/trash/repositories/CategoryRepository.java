package com.aquarium.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aquarium.models.tables.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

package com.aquarium.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aquarium.models.tables.ProductImage;

public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {
}

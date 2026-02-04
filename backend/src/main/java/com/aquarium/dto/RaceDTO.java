package com.aquarium.dto;

public record RaceDTO(
        Long id,
        String name,
        double purchasePrice,
        double salePrice,
        double maxWeight,
        double increaseCapacity) {
}

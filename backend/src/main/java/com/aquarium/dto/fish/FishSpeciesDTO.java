package com.aquarium.dto.fish;

import java.time.LocalDateTime;

public record FishSpeciesDTO(
                Long id,
                String name,
                double increaseCapacity,
                double maxWeight,
                double purchasePrice,
                double salePrice) {
}

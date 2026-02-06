package com.aquarium.dto.fish;

import java.math.BigDecimal;

public record FishSpeciesDTO(
                Long id,
                String name,
                BigDecimal increaseCapacity,
                BigDecimal maxWeight,
                BigDecimal purchasePrice,
                BigDecimal salePrice) {
}

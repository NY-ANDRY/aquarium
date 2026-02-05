package com.aquarium.dto.aquarium;

import java.time.LocalDateTime;

public record AquariumFishDTO(
        Long id,
        String name,
        String speciesName,
        LocalDateTime date,
        double weight) {
}
